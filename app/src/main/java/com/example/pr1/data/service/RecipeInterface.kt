package com.example.pr1.data.service

import com.example.pr1.data.model.Recipe
import retrofit2.http.Body
import retrofit2.http.POST

interface RecipeInterface {
    @POST("recipes/add")
    suspend fun addRecipe(@Body recipe: Recipe): Recipe
}