package com.example.pr1.data.model

data class CommentsResponse(
    val items: Comments,
    val page: Int,
    val perPage: Int,
    val totalItems: Int,
    val totalPages: Int
)
