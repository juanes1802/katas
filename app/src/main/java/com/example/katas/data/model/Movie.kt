package com.example.katas.data.model

import com.google.gson.annotations.SerializedName
import retrofit2.Retrofit

data class Movies(
    val page: Int?,
    val results: List<Movie>
)

data class Movies2(
    val page: Int?,
    val results: List<Movie2>
)

data class Movie (
    val title : String?,
    @SerializedName("release_date")
    val releaseDate : String?,
    val overview:String?,
    @SerializedName("poster_path")
    val posterPath: String?,
)

data class Movie2 (
    val title : String?,
    @SerializedName("vote_average")
    val  rating : String?,
    @SerializedName("poster_path")
    val posterPath: String?,


)





