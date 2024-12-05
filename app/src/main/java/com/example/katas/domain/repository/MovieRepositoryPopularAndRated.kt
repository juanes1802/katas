package com.example.katas.domain.repository

import com.example.katas.data.model.local.entity.MovieEntity
import com.example.katas.domain.model.MovieHome

interface MovieRepositoryPopularAndRated {
    suspend fun  getPopularMovies(): List<MovieHome>

    suspend fun  getPopularMoviesFromdatabase(): List<MovieHome>
    suspend  fun InsetPopularMovies(movies: List<MovieEntity>)
    suspend fun  ClearMovies()

    //para las mejores calificadas
    suspend fun  getRatedMovies(): List<MovieHome>
    suspend fun InsetTopRatedMovies(movies: List<MovieEntity>)
    suspend fun ClearTopRatedMovies()
    suspend fun getTopRatedFromdatabase(): List<MovieHome>
}