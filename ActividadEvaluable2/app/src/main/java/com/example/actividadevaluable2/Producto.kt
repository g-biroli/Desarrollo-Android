package com.example.actividadevaluable2.models

import kotlinx.serialization.Serializable

// Modelo de datos para representar un producto
@Serializable
data class Producto(
    val id: Int,
    val title: String,
    val price: Double,
    val thumbnail: String
)
