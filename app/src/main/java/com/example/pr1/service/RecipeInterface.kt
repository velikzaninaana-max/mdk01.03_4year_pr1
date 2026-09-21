package com.example.pr1.service

import com.example.pr1.model.Recipe
import retrofit2.http.Body
import retrofit2.http.POST

interface RecipeInterface {
    @POST("recipe/add")
    suspend fun addRecipe(@Body recipe: Recipe): Recipe
}