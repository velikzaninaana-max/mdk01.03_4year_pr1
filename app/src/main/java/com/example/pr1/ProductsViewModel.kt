package com.example.pr1

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ProductsViewModel: ViewModel() {
        fun deleteUser(id: Int){
            viewModelScope.launch {
                try {
                    val product = RetrofitClient.retrofitAPI.deleteProduct(id)
                    Log.d("ProductsViewModel", "$product")
                }catch (e: Exception){
                    Log.e("ProductsViewModel", "${e.message}", e)
                }
            }
    }
//    fun fetch(){
//        viewModelScope.launch {
//            try {
//                val productsResponse = RetrofitClient.retrofitAPI.getProducts()
//                val products = productsResponse.products
//                for (product in products) {
//                    Log.d("ProductsViewModel","Название: ${product.title}, категория: ${product.category}, рейтинг: ${product.rating}")
//                }
//            } catch (e: Exception) {
//                Log.e("ProductsViewModel","${e.message}", e)
//            }
//        }
//    }
}