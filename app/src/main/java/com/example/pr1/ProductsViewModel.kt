package com.example.pr1

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ProductsViewModel: ViewModel() {
    fun fetch(){
        viewModelScope.launch {
            try {
                val productsResponse = RetrofitClient.retrofitAPI.getProducts()
                val products = productsResponse.products
                for (product in products) {
                    Log.d("ProductsViewModel","Название: ${product.title}, категория: ${product.category}, рейтинг: ${product.rating}")
                }
            } catch (e: Exception) {
                Log.e(TAG,"${e.message}", e)
            }
        }
    }
}