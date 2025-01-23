package com.example.katas.domain.usecase.detail.recomendations

import com.example.katas.domain.model.MovieDetalle

interface GetMovieRecomendationsUseCase {

    suspend fun  execute(movieId: Int): List<MovieDetalle>
}