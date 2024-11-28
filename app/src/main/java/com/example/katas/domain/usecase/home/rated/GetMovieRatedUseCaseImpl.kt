package com.example.katas.domain.usecase.home.rated

import com.example.katas.domain.model.MovieHome
import com.example.katas.domain.repository.MovieRepositoryPopularAndRated
import javax.inject.Inject

class GetMovieRatedUseCaseImpl @Inject constructor(private val movieRepository: MovieRepositoryPopularAndRated) :
    GetMovieRatedUseCase {
    override suspend fun execute(): List<MovieHome> {
        return movieRepository.getRatedMovies()
    }
}