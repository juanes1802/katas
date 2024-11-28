package com.example.katas.domain.usecase.home.rated

import com.example.katas.domain.model.MovieHome

interface GetMovieRatedUseCase {
    suspend fun  execute(): List<MovieHome>

}