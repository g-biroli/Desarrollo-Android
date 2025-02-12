package com.example.actividadevaluable2

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.actividadevaluable2.models.Producto
import com.example.actividadevaluable2.network.ApiService

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ActividadEvaluable2App()
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ActividadEvaluable2App() {
    val productos = remember { mutableStateListOf<Producto>() }

    LaunchedEffect(Unit) {
        productos.addAll(ApiService.obtenerProductos())
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Tienda de Productos") },
                actions = {
                    IconButton(onClick = { /* Ir al carrito */ }) {
                        Icon(Icons.Default.ShoppingCart, contentDescription = "Ver Carrito")
                    }
                }
            )
        }
    ) {
        LazyColumn {
            items(productos) { producto ->
                ProductoItem(producto)
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
        elevation = 4.dp
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = rememberImagePainter(producto.thumbnail),
                contentDescription = null,
                modifier = Modifier.size(80.dp)
            )
            Column(modifier = Modifier.padding(8.dp)) {
                Text(producto.title, style = MaterialTheme.typography.h4)
                Text("Precio: ${producto.price}€", style = MaterialTheme.typography.body1)
                Button(onClick = { }) {
                    Text("Añadir al carrito")
                }
            }
        }
    }
}
