package com.example.katas.domain.model

import com.google.gson.annotations.SerializedName

data class MovieHome(
    val id: Int,
    val title: String?,
    val rating: String?,
    val posterPath: String?,
)