package com.example.katas.data.repository

import com.example.katas.data.mappers.toDomainModelList
import com.example.katas.data.network.ApiInterfaceTopRatingAndPopular
import com.example.katas.domain.model.MovieHome
import com.example.katas.domain.repository.MovieRepositoryPopularAndRated
import javax.inject.Inject

class MovieRepositoryPopularAndRatedImpl @Inject constructor(private val apiService: ApiInterfaceTopRatingAndPopular) :
    MovieRepositoryPopularAndRated {
    override suspend fun getPopularMovies(): List<MovieHome> {
        return try {
            val response = apiService.getPopularMovies()
            if (response.isSuccessful) {
                response.body()?.toDomainModelList()!!
            } else {
                throw Exception("Error en la respuesta: ${response.code()} - ${response.message()}")

            }
        } catch (e: Exception) {
            throw Exception("Error desconocido: ${e.message}")
        }
    }

}
