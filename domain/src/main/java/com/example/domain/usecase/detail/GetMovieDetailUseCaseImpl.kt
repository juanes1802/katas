package com.example.domain.usecase.detail

import com.example.katas.domain.model.MovieDetalle
import com.example.domain.repository.MovieRepositoryDetailsAndRecommendations

class GetMovieDetailUseCaseImpl(
   private val  movieRepository: MovieRepositoryDetailsAndRecommendations
) : GetMovieDetailUseCase {
    override suspend fun  execute(movieId: Int): MovieDetalle?{
        return   movieRepository.getMovieDetails(movieId)
    }
}