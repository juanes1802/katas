package com.example.katas.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.katas.data.model.MovieTopRatedAndPopular
import com.example.katas.data.model.MoviesTopRatedAndPopular
import com.example.katas.data.network.ApiInterfaceTopRatingAndPopular
import com.example.katas.service.ApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MoviesViewModel : ViewModel() {

    private var _moviesRated = MutableLiveData<List<MovieTopRatedAndPopular>>()
    val moviesRated: LiveData<List<MovieTopRatedAndPopular>> = _moviesRated
    private var _moviesPopular = MutableLiveData<List<MovieTopRatedAndPopular>>()
    var moviesPopular: LiveData<List<MovieTopRatedAndPopular>> = _moviesPopular


    fun loadMoviesRated() {
        CoroutineScope(Dispatchers.IO).launch {
            val apiservice =
                ApiService.getInstance().create(ApiInterfaceTopRatingAndPopular::class.java)
            try {
                val response = apiservice.getTopRatedMovies()
                if (response.isSuccessful && response.body() != null) {
                    val movieRating = response.body()!!.results
                    withContext(Dispatchers.Main) {
                        _moviesRated.value = movieRating
                    }

                }
            } catch (e: Exception) {
            }
        }
    }

    fun loadMoviesPopular() {
        CoroutineScope(Dispatchers.IO).launch {
            val apiService =
                ApiService.getInstance().create(ApiInterfaceTopRatingAndPopular::class.java)
            try {
                val response = apiService.getPopularMovies()
                if (response.isSuccessful && response.body() != null) {
                    val moviePopular = response.body()!!.results
                    withContext(Dispatchers.Main) {
                        _moviesPopular.value = moviePopular
                    }


                }
            } catch (e: Exception) {
            }
        }
    }
}


