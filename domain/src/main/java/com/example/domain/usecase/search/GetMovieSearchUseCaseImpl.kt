package com.example.domain.usecase.search

import com.example.katas.domain.model.MovieSearch
import com.example.katas.domain.repository.MovieRepositorySearch


class GetMovieSearchUseCaseImpl (private val movieRepository: MovieRepositorySearch) :
    GetMovieSearchUseCase {
    override suspend fun execute(): List<MovieSearch> {
        return movieRepository.getMovies()
    }

}