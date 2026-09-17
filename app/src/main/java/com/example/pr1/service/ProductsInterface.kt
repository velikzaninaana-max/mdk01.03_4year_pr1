package com.example.pr1.service

import com.example.pr1.model.ProductsResponse
import retrofit2.http.GET

interface ProductsInterface {
    @GET("products")
    suspend fun getProducts(): ProductsResponse
}