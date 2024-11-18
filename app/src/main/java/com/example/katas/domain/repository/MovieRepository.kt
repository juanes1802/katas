package com.example.katas.domain.repository

import com.example.katas.data.model.remote.responses.MoviesResponseDetalle
import com.example.katas.domain.model.MovieDetalle


interface MovieRepository {
    suspend fun getMovieDetails(movieId: Int): MovieDetalle?
}