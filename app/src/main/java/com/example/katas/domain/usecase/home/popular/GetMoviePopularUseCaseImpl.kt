package com.example.katas.domain.usecase.home.popular

import com.example.katas.data.mappers.toDatabase
import com.example.katas.domain.model.MovieHome
import com.example.katas.domain.repository.MovieRepositoryPopularAndRated
import javax.inject.Inject

class GetMoviePopularUseCaseImpl @Inject constructor(
    private val movieRepository: MovieRepositoryPopularAndRated

) : GetMoviePopularUseCase {
    override suspend fun execute(): List<MovieHome> {
        val movies = movieRepository.getPopularMovies()
        return if (movies.isNotEmpty()) {
            movieRepository.ClearMovies()
            movieRepository.InsetPopularMovies(movies.map { it.toDatabase() })
            movies

        } else {
            movieRepository.getPopularMoviesFromdatabase()
        }

    }
}