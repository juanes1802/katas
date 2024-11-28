package com.example.katas.domain.usecase.home.popular

import com.example.katas.domain.model.MovieHome

interface GetMoviePopularUseCase {
    suspend fun  execute(): List<MovieHome>
}