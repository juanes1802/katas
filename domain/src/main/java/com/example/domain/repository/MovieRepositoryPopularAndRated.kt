package com.example.domain.repository

import com.example.domain.model.MovieEntityDomain

import com.example.katas.domain.model.MovieHome

interface MovieRepositoryPopularAndRated {
    suspend fun  getPopularMovies(): List<MovieHome>

    suspend fun  getPopularMoviesFromdatabase(): List<MovieHome>
    suspend  fun InsetPopularMovies(movies: List<MovieHome>)
    suspend fun  ClearMovies()

    //para las mejores calificadas
    suspend fun  getRatedMovies(): List<MovieHome>
    suspend fun InsetTopRatedMovies(movies: List<MovieHome>)
    suspend fun ClearTopRatedMovies()
    suspend fun getTopRatedFromdatabase(): List<MovieHome>
}