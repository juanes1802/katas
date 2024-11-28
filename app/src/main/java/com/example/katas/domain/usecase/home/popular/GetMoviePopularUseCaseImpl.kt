package com.example.katas.domain.usecase.home.popular

import com.example.katas.domain.model.MovieHome
import com.example.katas.domain.repository.MovieRepositoryPopularAndRated
import javax.inject.Inject

class GetMoviePopularUseCaseImpl @Inject constructor(
    private val  movieRepository: MovieRepositoryPopularAndRated

): GetMoviePopularUseCase {
    override suspend fun execute(): List<MovieHome> {
        return movieRepository.getPopularMovies()
    }
}