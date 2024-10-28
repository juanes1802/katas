package com.example.katas.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.katas.data.model.MovieSearch
import com.example.katas.service.ApiInterfaceBuscar
import com.example.katas.service.ApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SearchViewModel : ViewModel() {
    private val _movies = MutableLiveData<List<MovieSearch>>()
    val movies: LiveData<List<MovieSearch>> = _movies

    private var _filteredMovies = MutableLiveData<List<MovieSearch>>()

    val filteredMovies: LiveData<List<MovieSearch>> = _filteredMovies
    private var originalMovieList: List<MovieSearch> = emptyList()

    fun loadMovies() {
        CoroutineScope(Dispatchers.IO).launch {
            val apiService = ApiService.getInstance().create(ApiInterfaceBuscar::class.java)
            try {
                val response = apiService.getMovies()
                if (response.isSuccessful && response.body() != null) {
                    val movieSearch = response.body()!!.results
                    withContext(Dispatchers.Main) {
                        _movies.value = movieSearch
                        originalMovieList = movieSearch
                        _filteredMovies.value = movieSearch
                    }

                }

            } catch (e: Exception) {


            }
        }


    }

    fun filterMovies(title: String) {
        val filteredList = originalMovieList.filter {
            it.title?.toLowerCase()?.contains(title.toLowerCase()) == true

        }
        _filteredMovies.value = filteredList
    }
}
