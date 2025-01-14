package com.example.actividadevaluable2.network

import com.example.actividadevaluable2.models.Producto
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

// Servicio para obtener datos de la API
object ApiService {
    private val client = HttpClient(CIO)

    // Obtiene la lista de productos desde la API
    suspend fun obtenerProductos(): List<Producto> {
        return withContext(Dispatchers.IO) {
            client.get("https://dummyjson.com/products").body()
        }
    }
}
