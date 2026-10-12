package com.example.pr1.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pr1.data.RetrofitClient
import com.example.pr1.data.TokenManager
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class CommentViewModel(val tokenManager: TokenManager): ViewModel() {
    private val token: StateFlow<String?> = tokenManager.tokenFlow()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = null
        )
    fun getComment(){
        if (token != null)
        viewModelScope.launch{
            try {
                val comments = RetrofitClient.commentsAPI.getComments("Bearer ${token.value}")
                Log.d("LoginViewModel", "items: ${comments.items},\n page: ${comments.page},\n perPage: ${comments.perPage},\n totalItems: ${comments.totalItems},\n totalPages: ${comments.totalPages}")
            }catch (ex: Exception){
                Log.e("CommentViewModel", ex.message.toString())
            }
        }
    }
}