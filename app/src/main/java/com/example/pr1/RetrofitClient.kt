package com.example.pr1

import com.example.pr1.service.ProductsInterface
import com.example.pr1.service.RecipeInterface
import com.example.pr1.service.UserInterface
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.InetSocketAddress
import java.net.Proxy

object RetrofitClient {
    val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    val proxy = Proxy(Proxy.Type.HTTP, InetSocketAddress("10.207.106.59", 3128))

    val client = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .proxy(proxy)
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl("https://dummyjson.com/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val retrofitAPI: ProductsInterface = retrofit.create(ProductsInterface::class.java)
    val recipeAPI: RecipeInterface = retrofit.create(RecipeInterface::class.java)
    val userAPI: UserInterface = retrofit.create(UserInterface::class.java)
}