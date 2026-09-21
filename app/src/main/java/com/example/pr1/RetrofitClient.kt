package com.example.pr1

import com.example.pr1.service.ProductsInterface
import com.example.pr1.service.RecipeInterface
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    val client = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl("https://dummyjson.com/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val retrofitAPI: ProductsInterface = retrofit.create(ProductsInterface::class.java)
    val recipeAPI: RecipeInterface = retrofit.create(RecipeInterface::class.java)
}