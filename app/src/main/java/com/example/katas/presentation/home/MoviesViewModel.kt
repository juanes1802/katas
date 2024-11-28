package com.example.katas.presentation.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.katas.data.model.entities.MovieTopRatedAndPopularDto
import com.example.katas.data.model.local.dao.MovieDao
import com.example.katas.data.model.local.entity.MovieEntity
import com.example.katas.data.network.ApiInterfaceTopRatingAndPopular
import com.example.katas.data.network.ApiService
import com.example.katas.domain.model.MovieHome
import com.example.katas.domain.usecase.home.popular.GetMoviePopularUseCase
import com.example.katas.domain.usecase.home.rated.GetMovieRatedUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(

    private val getMoviePopularUseCase: GetMoviePopularUseCase,
    private val getMovieRatedUseCase: GetMovieRatedUseCase
) : ViewModel() {

    private var _moviesRated = MutableLiveData<List<MovieHome>>()
    val moviesRated: LiveData<List<MovieHome>> = _moviesRated
    private var _moviesPopular = MutableLiveData<List<MovieHome>>()
    var moviesPopular: LiveData<List<MovieHome>> = _moviesPopular


    fun loadMoviesRated() {
        viewModelScope.launch {
            try {
                val moviesRated = getMovieRatedUseCase.execute()
                _moviesRated.postValue(moviesRated)
            } catch (e: IOException) {
                Log.e("MoviesViewModel", "Error de red al cargar las películas populares", e)
            } catch (e: HttpException) {
                Log.e("MoviesViewModel", "Error Http: ${e.message()} ")
            } catch (e: Exception) {
                Log.e("MoviesViewModel", "Error desconocido: ${e.message}")
            }
        }

    }

    fun loadMoviesPopular() {
        viewModelScope.launch {

            try {
                val moviesPopular = getMoviePopularUseCase.execute()

                _moviesPopular.postValue(moviesPopular)


            } catch (e: IOException) {
                Log.e("MoviesViewModel", "Error de red al cargar las películas populares", e)
            } catch (e: HttpException) {
                Log.e("MoviesViewModel", "Error Http: ${e.message()} ")
            } catch (e: Exception) {
                Log.e("MoviesViewModel", "Error desconocido: ${e.message}")
            }


        }
    }


}





