package com.example.actividadevaluable2

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import com.example.actividadevaluable2.models.Producto
import com.example.actividadevaluable2.viewmodel.CartViewModel
import java.lang.reflect.Modifier

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CarritoScreen()
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CarritoScreen() {
    val carrito = remember { mutableStateListOf<Producto>() }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Carrito de Compras") })
        }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            LazyColumn {
                items(carrito) { producto ->
                    Text("${producto.title} - ${producto.price}€")
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { carrito.clear() }) {
                Text("Vaciar Carrito")
            }
        }
    }
}
