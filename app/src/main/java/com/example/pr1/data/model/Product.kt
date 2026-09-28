package com.example.pr1.data.model

data class Product(
    val id: Int? = null,
    val title: String,
    val category: String,
    val rating: Double,
    val isDeleted: Boolean = false
)
