package com.example.domain.usecase.home.popular



import com.example.katas.domain.model.MovieHome
import com.example.domain.repository.MovieRepositoryPopularAndRated

class GetMoviePopularUseCaseImpl (
    private val movieRepository: MovieRepositoryPopularAndRated

) : GetMoviePopularUseCase {
    override suspend fun execute(): List<MovieHome> {
        val movies = movieRepository.getPopularMovies()
        return if (movies.isNotEmpty()) {
            movieRepository.ClearMovies()
            movieRepository.InsetPopularMovies(movies)
            movies
        } else {
            movieRepository.getPopularMoviesFromdatabase()
        }

    }
}