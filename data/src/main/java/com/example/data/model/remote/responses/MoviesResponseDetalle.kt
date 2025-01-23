package com.example.data.model.remote.responses

import com.example.data.model.entities.MovieDetalleDto

data class MoviesResponseDetalle(
    val page: Int?,
    val results: List<MovieDetalleDto>
)