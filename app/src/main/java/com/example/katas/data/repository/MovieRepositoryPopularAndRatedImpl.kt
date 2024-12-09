package com.example.katas.data.repository

import com.example.katas.data.mappers.toDomainModel
import com.example.katas.data.mappers.toDomainModelList
import com.example.katas.data.model.local.dao.MovieDao
import com.example.katas.data.model.local.entity.MovieEntity
import com.example.katas.data.network.ApiInterfaceTopRatingAndPopular
import com.example.katas.domain.model.MovieHome
import com.example.domain.repository.MovieRepositoryPopularAndRated
import com.example.katas.data.mappers.toDataBaseEntity

import com.example.katas.data.mappers.toMovieEntityDomain

import javax.inject.Inject

class MovieRepositoryPopularAndRatedImpl @Inject constructor(
    private val apiService: ApiInterfaceTopRatingAndPopular,
    private val movieDao: MovieDao
) :
    MovieRepositoryPopularAndRated {
    override suspend fun getPopularMovies(): List<MovieHome> {
        return try {
            val response = apiService.getPopularMovies()
            if (response.isSuccessful) {
                response.body()?.toDomainModelList()!!
            } else {
                emptyList()

            }
        } catch (e: Exception) {
            emptyList()
        }
    }

    override suspend fun getPopularMoviesFromdatabase(): List<MovieHome> {
        val response: List<MovieEntity> = movieDao.getAllMovies()
        return response.map { it.toDomainModel() }

    }

    override suspend fun InsetPopularMovies(movies: List<MovieHome>) {
        val movieEntityList = movies.map { it.toMovieEntityDomain().toDataBaseEntity() }
        movieDao.movieInsertAll(movieEntityList)
    }


    override suspend fun ClearMovies() {
        movieDao.deleteAllMovies()
    }

    override suspend fun getRatedMovies(): List<MovieHome> {
        return try {
            val response = apiService.getTopRatedMovies()
            if (response.isSuccessful) {
                response.body()?.toDomainModelList()!!
            } else {
                emptyList()
            }
        } catch (e: Exception) {
            emptyList()
        }
    }

    override suspend fun InsetTopRatedMovies(movies: List<MovieHome>) {
        movieDao.movieInsertAll(movies.map { it.toMovieEntityDomain().toDataBaseEntity() })
    }

    override suspend fun ClearTopRatedMovies() {
        movieDao.deleteAllMovies()
    }

    override suspend fun getTopRatedFromdatabase(): List<MovieHome> {
        return movieDao.getAllMovies().map { it.toDomainModel() }
    }


}
