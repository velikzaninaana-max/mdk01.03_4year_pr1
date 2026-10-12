package com.example.pr1.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pr1.data.RetrofitClient
import com.example.pr1.data.TokenManager
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class CommentViewModel(private val tokenManager: TokenManager): ViewModel() {
//    private val token: StateFlow<String?> = tokenManager.tokenFlow()
//        .stateIn(
//            scope = viewModelScope,
//            started = SharingStarted.WhileSubscribed(5000),
//            initialValue = null
//        )
    fun getComment(){
        viewModelScope.launch{
            val token = tokenManager.tokenFlow().first()
            if (token != null)
            try {
                val comments = RetrofitClient.commentsAPI.getComments("Bearer ${token}")
                for (item in comments.items) {
                    Log.d("CommentViewModel", "id: ${item.id},\n body: ${item.body},\n likes: ${item.likes},\n created: ${item.created},\n updated: ${item.updated}")
                }
                Log.d("CommentViewModel", "page: ${comments.page},\n perPage: ${comments.perPage},\n totalItems: ${comments.totalItems},\n totalPages: ${comments.totalPages}")
            }catch (ex: Exception){
                Log.e("CommentViewModel", ex.message.toString())
            }
        }
    }
}