package com.example.katas.domain.usecase.detail

import com.example.katas.domain.model.MovieDetalle
import com.example.katas.domain.repository.MovieRepositoryDetailsAndRecommendations
import javax.inject.Inject

class GetMovieDetailUseCaseImpl(
   private val  movieRepository: MovieRepositoryDetailsAndRecommendations
) : GetMovieDetailUseCase {
    override suspend fun  execute(movieId: Int): MovieDetalle?{
        return   movieRepository.getMovieDetails(movieId)
    }
}