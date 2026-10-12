package com.example.pr1.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pr1.data.RetrofitClient
import com.example.pr1.data.TokenManager
import com.example.pr1.data.model.LoginRequest
import kotlinx.coroutines.launch

class LoginViewModel(private val tokenManager: TokenManager, val commentViewModel: CommentViewModel): ViewModel() {
//    private val token: StateFlow<String?> = tokenManager.tokenFlow()
//        .stateIn(
//            scope = viewModelScope,
//            started = SharingStarted.WhileSubscribed(5000),
//            initialValue = null
//        )
    fun loginPost(loginRequest: LoginRequest) {
        viewModelScope.launch {
            try {
                val login = RetrofitClient.loginAPI.postLogin(loginRequest)
                Log.d("LoginViewModel",login.token)
                login.token.let {
                    tokenManager.saveToken(it)
                    commentViewModel.getComment()
                }
            }catch (ex: Exception){
                Log.e("LoginViewModel", ex.message.toString())
            }
        }
    }
}