package com.example.katas.domain.usecase.search

import com.example.katas.domain.model.MovieSearch
import com.example.katas.domain.repository.MovieRepositorySearch
import javax.inject.Inject

class GetMovieSearchUseCaseImpl (private val movieRepository: MovieRepositorySearch) :
    GetMovieSearchUseCase {
    override suspend fun execute(): List<MovieSearch> {
        return movieRepository.getMovies()
    }

}