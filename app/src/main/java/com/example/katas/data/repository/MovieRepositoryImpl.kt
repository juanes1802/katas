package com.example.katas.data.repository

import android.util.Log
import com.example.katas.data.mappers.toDomainModel
import com.example.katas.data.mappers.toDomainModelList
import com.example.katas.data.model.remote.responses.MoviesResponseDetalle
import com.example.katas.data.network.ApiInterfaceDetalle
import com.example.katas.domain.model.MovieDetalle
import com.example.katas.domain.repository.MovieRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val apiService: ApiInterfaceDetalle) :
    MovieRepository {

    override suspend fun getMovieDetails(movieId: Int): MovieDetalle? {
        return try {
            val response = apiService.getMovieDetails(movieId)
            if (response.isSuccessful) {
                response.body()?.toDomainModel()
            } else {
                throw Exception("Error en la respuesta: ${response.code()} - ${response.message()}")
            }


        } catch (e: IOException) {
            throw Exception("Error de red: ${e.message}")

        } catch (e: HttpException) {
            throw Exception("Error Http: ${e.message()}")
        }
    }


}




