package com.example.actividadevaluable2

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.actividadevaluable2.models.Producto
import com.example.actividadevaluable2.network.ApiService

// Lista compartilhada de produtos no carrinho
val carrito = mutableStateListOf<Producto>()

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ActividadEvaluable2App()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ActividadEvaluable2App() {
    val context = LocalContext.current
    val productos = remember { mutableStateListOf<Producto>() }

    // Carregar produtos da API
    LaunchedEffect(Unit) {
        productos.addAll(ApiService.obtenerProductos())
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Tienda de Productos") },
                actions = {
                    IconButton(onClick = {
                        val intent = Intent(context, SecondActivity::class.java)
                        context.startActivity(intent)
                    }) {
                        Icon(Icons.Default.ShoppingCart, contentDescription = "Ver Carrito")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            if (productos.isEmpty()) {
                Text(
                    "No hay productos disponibles",
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.titleLarge
                )
            } else {
                LazyColumn {
                    items(productos) { producto ->
                        ProductoItem(producto)
                    }
                }
            }
        }
    }
}

@Composable
fun ProductoItem(producto: Producto) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { },
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = rememberAsyncImagePainter(producto.thumbnail),
                contentDescription = null,
                modifier = Modifier.size(80.dp)
            )
            Column(modifier = Modifier.padding(8.dp)) {
                Text(producto.title, style = MaterialTheme.typography.titleLarge)
                Text("Precio: ${producto.price}€", style = MaterialTheme.typography.bodyMedium)
                Button(onClick = {
                    carrito.add(producto) // Adiciona produto ao carrinho
                }) {
                    Text("Añadir al carrito")
                }
            }
        }
    }
}

