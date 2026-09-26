package com.example.pr1.service

import com.example.pr1.model.Product
import com.example.pr1.model.ProductsResponse
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductsInterface {
    @GET("products")
    suspend fun getProducts(): ProductsResponse

    @DELETE("products/{id}")
    suspend fun deleteProduct(@Path("id") id: Int): Product
}