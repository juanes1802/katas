package com.example.katas.domain.repository

import com.example.katas.domain.model.Movie

interface MovieRepository {
    suspend fun getMovieDetails(): List<Movie>
}