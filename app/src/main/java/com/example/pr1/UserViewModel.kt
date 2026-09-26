package com.example.pr1

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pr1.model.Address
import com.example.pr1.model.User
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {
    fun updateUser(){
        viewModelScope.launch {
            val user = RetrofitClient.userAPI.getUser(16)
            Log.d("UserViewModel", "$user")

            val address = Address(
                address = "пр-т Мира, 18",
                city = "г. Заволжье"
            )
            val newUser = user.copy(
                firstName = "Антон",
                lastName = "Кудрин",
                gender = "мужской",
                address = address
            )
            try {
                if (newUser.id != null){
                    val updateUser = RetrofitClient.userAPI.updateUser(
                        newUser.id,
                        newUser
                    )
                    Log.d("UserViewModel", "$updateUser")
                }
            }catch (e: Exception){
                Log.e("UserViewModel", "${e.message}", e)
            }
        }
    }
}