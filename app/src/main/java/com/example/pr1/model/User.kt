package com.example.pr1.model

data class User(
    val id: Int? = null,
    val firstName: String,
    val lastName: String,
    val gender: String,
    val address: Address
)
