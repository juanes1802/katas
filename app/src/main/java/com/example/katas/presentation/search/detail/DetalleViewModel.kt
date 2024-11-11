package com.example.katas.presentation.search.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.katas.data.model.MovieDetalle
import com.example.katas.data.network.ApiInterfaceDetalle
import com.example.katas.service.ApiService
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

//TODO implementar hilt y colocar en el constructor la referencia del use case GetMovieDetailUseCase
class DetalleViewModel : ViewModel() {
    private val apiService = ApiService.getInstance().create(ApiInterfaceDetalle::class.java)
    private val _recommendations = MutableLiveData<List<MovieDetalle>>()
    val recommendations: LiveData<List<MovieDetalle>> get() = _recommendations
    private val _movieDetails = MutableLiveData<MovieDetalle>()
    val movieDetails: LiveData<MovieDetalle> get() = _movieDetails

    fun fetchRecommendations(movieId: Int) {
        viewModelScope.launch {
            try {
                val response = apiService.getMovieRecomendations(movieId)
                if (response.isSuccessful) {
                    val results = response.body()?.results ?: emptyList()
                    Log.d("com.example.katas.presentation.search.detail.DetalleViewModel", "Recomendaciones obtenidas: $results")
                    _recommendations.postValue(results)
                } else {
                    Log.e("com.example.katas.presentation.search.detail.DetalleViewModel", "Error en la respuesta: ${response.code()} - ${response.message()}")
                }
            } catch (e: IOException) {
                Log.e("com.example.katas.presentation.search.detail.DetalleViewModel", "Error de red: ${e.message}")
            } catch (e: HttpException) {
                Log.e("com.example.katas.presentation.search.detail.DetalleViewModel", "Error HTTP: ${e.message()}")
            } catch (e: Exception) {
                Log.e("com.example.katas.presentation.search.detail.DetalleViewModel", "Error desconocido: ${e.message}")
            }
        }
    }

    fun fetchMovieDetails(movieId: Int){
        viewModelScope.launch {
            //TODO aqui cambiar por el use case
            val response = apiService.getMovieDetails(movieId)
            if (response.isSuccessful){
                _movieDetails.postValue(response.body())
            }else {
                Log.e("com.example.katas.presentation.search.detail.DetalleViewModel", "Error: ${response.code()} - ${response.message()}")
            }
        }
    }
}
