package com.example.katas.data.repository

import com.example.katas.domain.model.Movie
import com.example.katas.domain.repository.MovieRepository

class MovieRepositoryImpl : MovieRepository {
    override suspend fun getMovieDetails(): List<Movie> {
        TODO("Not yet implemented")
    }

}