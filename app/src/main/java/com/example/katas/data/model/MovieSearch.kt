package com.example.katas.data.model

import androidx.lifecycle.MutableLiveData
import com.google.gson.annotations.SerializedName

data class  MoviesSearch(
    val page: Int?,
    val results: List<MovieSearch>
)

data class MoviesTopRatedAndPopular(
    val page: Int?,
    val results: List<MovieTopRatedAndPopular>
)

 data class MovieSearch (
    val title : String?,
    @SerializedName("release_date")
    val releaseDate : String?,
    val overview:String?,
    @SerializedName("poster_path")
    val posterPath: String?,
)

data class MovieTopRatedAndPopular (
    val title : String?,
    @SerializedName("vote_average")
    val  rating : String?,
    @SerializedName("poster_path")
    val posterPath: String?,


)





