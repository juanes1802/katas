package com.example.katas.domain.usecase.home.rated

import com.example.katas.data.mappers.toDatabase
import com.example.katas.domain.model.MovieHome
import com.example.katas.domain.repository.MovieRepositoryPopularAndRated
import javax.inject.Inject

class GetMovieRatedUseCaseImpl (private val movieRepository: MovieRepositoryPopularAndRated) :
    GetMovieRatedUseCase {
    override suspend fun execute(): List<MovieHome> {
        val movie = movieRepository.getRatedMovies()
        return if (movie.isNotEmpty()) {
            movieRepository.ClearTopRatedMovies()
            movieRepository.InsetTopRatedMovies(movie.map { it.toDatabase() })
            movie

        } else {
            movieRepository.getTopRatedFromdatabase()
        }

    }
}