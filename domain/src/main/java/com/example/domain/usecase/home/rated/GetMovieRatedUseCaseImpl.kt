package com.example.domain.usecase.home.rated


import com.example.katas.domain.model.MovieHome
import com.example.domain.repository.MovieRepositoryPopularAndRated



class GetMovieRatedUseCaseImpl (private val movieRepository: MovieRepositoryPopularAndRated) :
    GetMovieRatedUseCase {
    override suspend fun execute(): List<MovieHome> {
        val movie = movieRepository.getRatedMovies()
        return if (movie.isNotEmpty()) {
            movieRepository.ClearTopRatedMovies()
            movieRepository.InsetTopRatedMovies(movie)
            movie

        } else {
            movieRepository.getTopRatedFromdatabase()
        }

    }
}