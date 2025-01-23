package com.example.data.model.remote.responses

import com.example.data.model.entities.MovieSearchDto

data class MoviesResponseSearch(
    val page: Int?,
    val results: List<MovieSearchDto>
)