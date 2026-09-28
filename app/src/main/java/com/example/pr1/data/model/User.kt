package com.example.pr1.data.model

data class User(
    val id: Int? = null,
    val firstName: String,
    val lastName: String,
    val gender: String,
    val address: Address
)
