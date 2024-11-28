package com.example.katas.domain.repository

import com.example.katas.domain.model.MovieHome

interface MovieRepositoryPopularAndRated {
    suspend fun  getPopularMovies(): List<MovieHome>
}