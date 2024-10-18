package com.example.katas.data.network

import com.example.katas.data.model.Movies2
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface2 {
    @GET("top_rated?api_key=c5c47722a4adcc77f6e84f28a48b857a")

    fun getMovies2(): Call<Movies2>
}