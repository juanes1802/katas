package com.example.katas.di

import com.example.katas.data.network.ApiInterfaceDetalle
import com.example.katas.data.repository.MovieRepositoryImpl
import com.example.katas.domain.repository.MovieRepository
import com.example.katas.domain.usecase.GetMovieDetailUseCase
import com.example.katas.domain.usecase.GetMovieDetailUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
 abstract class AppModule {

     @Binds
     abstract  fun bindMovieRepository(impl: MovieRepositoryImpl): MovieRepository

     @Binds
     abstract  fun bindGetMovieDetailUsecase(impl: GetMovieDetailUseCaseImpl):GetMovieDetailUseCase

}