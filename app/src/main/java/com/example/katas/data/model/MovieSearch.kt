package com.example.katas.data.model

import com.google.gson.annotations.SerializedName

data class MoviesResponseSearch(
    val page: Int?,
    val results: List<MovieSearch>
)

data class MovieSearch(
    @SerializedName("title")
    val title: String?,
    @SerializedName("release_date")
    val releaseDate: String?,
    val overview: String?,
    @SerializedName("poster_path")
    val posterPath: String?,
    val id: Int?
)


data class MoviesResponseTopRatedAndPopular(
    val page: Int?,
    val results: List<MovieTopRatedAndPopular>
)


data class MovieTopRatedAndPopular(
    val title: String?,
    @SerializedName("vote_average")
    val rating: String?,
    @SerializedName("poster_path")
    val posterPath: String?,


    )

data class MoviesResponseDetalle(
    val page: Int?,
    val results: List<MovieDetalle>
)

data class Genero(
    val id: Int?,
    val name: String?
)

data class MovieDetalle(
    val id: Int?,
    @SerializedName("vote_average")
    val rating: String?,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("backdrop_path")
    val backdropPath: String?,
    val title: String?,
    @SerializedName("original_title")
    val originalTitle: String?,
    val overview: String?,
    val genres: List<Genero>



)






