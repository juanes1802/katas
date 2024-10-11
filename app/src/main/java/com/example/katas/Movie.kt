package com.example.katas

import com.google.gson.annotations.SerializedName
import retrofit2.Retrofit

data class Movies(
    val page: Int?,
    val results: List<Movie>
)

data class Movie (
    val title : String?,
    @SerializedName("release_date")
    val releaseDate : String?,
    val overview:String?,
    @SerializedName("poster_path")
    val posterPath: String?,
)





