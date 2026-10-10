package com.example.pr1.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pr1.data.RetrofitClient
import com.example.pr1.data.model.LoginRequest
import com.example.pr1.data.model.LoginResponse
import kotlinx.coroutines.launch

class CommentViewModel: ViewModel() {
    fun loginAndComments(loginRequest: LoginRequest) {
        viewModelScope.launch {
            try {
                val login = RetrofitClient.loginAPI.postLogin(loginRequest)
                Log.d("CommentViewModel","Response: ${login.token}, ${login.record}")
                val comments = RetrofitClient.commentsAPI.getComments("Bearer ${login.token}")
                Log.d("CommentViewModel", "items: ${comments.items},\n page: ${comments.page},\n perPage: ${comments.perPage},\n totalItems: ${comments.totalItems},\n totalPages: ${comments.totalPages}")
            }catch (e: Exception){
                Log.e("CommentViewModel", "${e.message}", e)
            }
        }
    }
}