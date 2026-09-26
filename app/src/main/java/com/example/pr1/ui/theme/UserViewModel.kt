package com.example.pr1.ui.theme

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pr1.RetrofitClient
import com.example.pr1.model.User
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {
    fun getUser(id: Int){
        viewModelScope.launch {
            try {
                val user = RetrofitClient.userAPI.getUser(id)
                Log.d("UserViewModel","До обновления: \n ${user.id},\n ${user.firstName},\n ${user.lastName},\n ${user.gender},\n ${user.address.address}, ${user.address.city}")
            }catch (e: Exception){
                Log.e("UserViewModel", "${e.message}", e)
            }
        }
    }
    fun updateUser(id: Int, user: User){
        viewModelScope.launch {
            try {
                val user = RetrofitClient.userAPI.updateUser(id, user)
                if (id != null){
                    Log.d("UserViewModel"," После обновления: \n ${user.id},\n ${user.firstName},\n ${user.lastName},\n ${user.gender},\n ${user.address.address}, ${user.address.city}")
                }

            }catch (e: Exception){
                Log.e("UserViewModel", "${e.message}", e)
            }
        }
    }
}