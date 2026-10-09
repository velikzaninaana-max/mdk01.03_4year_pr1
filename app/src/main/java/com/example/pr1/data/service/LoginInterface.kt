package com.example.pr1.data.service

import com.example.pr1.data.model.LoginRequest
import com.example.pr1.data.model.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginInterface {
    @POST("users/auth-with-password")
    suspend fun postLogin(@Body loginRequest: LoginRequest): LoginResponse
}