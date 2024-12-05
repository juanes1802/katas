package com.example.katas.domain.usecase.search

import com.example.katas.domain.model.MovieSearch

interface GetMovieSearchUseCase {
    suspend fun execute(): List<MovieSearch>

}