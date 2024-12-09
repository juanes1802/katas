package com.example.domain.usecase.home.rated

import com.example.domain.model.MovieEntityDomain
import com.example.katas.domain.model.MovieHome

interface GetMovieRatedUseCase {
    suspend fun  execute(): List<MovieHome>

}