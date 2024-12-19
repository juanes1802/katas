package com.example.data.model.remote.responses

import com.example.data.model.entities.MovieTopRatedAndPopularDto

data class MoviesResponseTopRatedAndPopular(
    val page: Int?,
    val results: List<MovieTopRatedAndPopularDto>
)