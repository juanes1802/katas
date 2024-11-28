package com.example.katas.domain.usecase.detail


import com.example.katas.domain.model.MovieDetalle


interface GetMovieDetailUseCase {
    suspend fun  execute(movieId: Int): MovieDetalle?

}