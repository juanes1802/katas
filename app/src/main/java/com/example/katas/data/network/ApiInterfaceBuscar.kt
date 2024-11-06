package com.example.katas.service



import com.example.katas.data.model.MoviesResponseSearch
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterfaceBuscar {
@GET("top_rated?api_key=c5c 47722a4adcc77f6e84f28a48b857a")
  suspend  fun   getMovies(): Response<MoviesResponseSearch>

}

