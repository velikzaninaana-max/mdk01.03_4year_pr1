package com.example.pr1.data.service

import com.example.pr1.data.model.CommentsResponse
import retrofit2.http.GET
import retrofit2.http.Header

interface CommentsInterface {
    @GET("comments/records")
    suspend fun getComments(@Header("Authorization") token: String): CommentsResponse
}