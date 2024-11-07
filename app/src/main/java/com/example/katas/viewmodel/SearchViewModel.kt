package com.example.katas.viewmodel

import android.util.Log
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
import java.util.Locale

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
                    // withContext(Dispatchers.Main) {
                    _movies.postValue(movieSearch)
                    originalMovieList = movieSearch
                    _filteredMovies.postValue(movieSearch)
                    //}

                } else {
                    // siled class
                }

            } catch (e: Exception) {
                Log.e("SearchViewModel", "Error loading movies", e)


            }
        }


    }

    fun filterMovies(title: String) {
        val filteredList = originalMovieList.filter {
            it.title?.lowercase(Locale.getDefault())
                ?.contains(title.lowercase(Locale.getDefault())) == true

        }
        _filteredMovies.value = filteredList
    }
}
