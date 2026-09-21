package com.example.pr1

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pr1.model.Recipe
import kotlinx.coroutines.launch

class RecipeViewModel: ViewModel() {
    fun addRecipe(recipe: Recipe){
        viewModelScope.launch {
            try {
                val recipe = RetrofitClient.recipeAPI.addRecipe(recipe)
                Log.d("RecipeViewModel","${recipe.id}, ${recipe.name}, ${recipe.instructions}, ${recipe.tags}, ${recipe.rating}")
            } catch (e: Exception) {
                Log.e("RecipeViewModel", "${e.message}", e)
            }
        }
    }
}