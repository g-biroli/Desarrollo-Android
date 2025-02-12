package com.example.actividadevaluable2.network

import com.example.actividadevaluable2.models.Producto
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import android.util.Log

// Servicio para obtener datos de la API
object ApiService {
    // Cliente HTTP con soporte para JSON
    private val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true // Ignora campos desconhecidos no JSON
            })
        }
    }

    // Función para obtener la lista de productos desde la API
    suspend fun obtenerProductos(): List<Producto> {
        return try {
            withContext(Dispatchers.IO) {
                val response: ProductoResponse = client.get("https://dummyjson.com/products").body()
                Log.d("API_SUCCESS", "Productos cargados: ${response.products.size}") // Log para depuração
                response.products
            }
        } catch (e: Exception) {
            Log.e("API_ERROR", "Erro ao obter produtos: ${e.message}")
            emptyList() // Retorna uma lista vazia para evitar crash
        }
    }
}

// Modelo de resposta da API
@Serializable
data class ProductoResponse(
    val products: List<Producto>
)

