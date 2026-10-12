package com.example.pr1.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pr1.data.RetrofitClient
import com.example.pr1.data.TokenManager
import com.example.pr1.data.model.LoginRequest
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class LoginViewModel(val tokenManager: TokenManager): ViewModel() {
    private val token: StateFlow<String?> = tokenManager.tokenFlow()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = null
        )
    fun loginPost(loginRequest: LoginRequest) {
        viewModelScope.launch {
            try {
                val login = RetrofitClient.loginAPI.postLogin(loginRequest)
                Log.d("LoginViewModel","Response: ${login.token}, ${login.record}")
            }catch (e: Exception){
                Log.e("LoginViewModel", "${e.message}", e)
            }
        }
    }
}