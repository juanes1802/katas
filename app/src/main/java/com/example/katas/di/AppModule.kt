package com.example.katas.di

import com.example.katas.data.repository.MovieRepositoryDetailsAndRecommendationsImpl
import com.example.katas.data.repository.MovieRepositoryPopularAndRatedImpl
import com.example.katas.data.repository.MovieRepositorySearchImpl
import com.example.katas.domain.repository.MovieRepositoryDetailsAndRecommendations
import com.example.katas.domain.repository.MovieRepositoryPopularAndRated
import com.example.katas.domain.repository.MovieRepositorySearch
import com.example.katas.domain.usecase.detail.GetMovieDetailUseCase
import com.example.katas.domain.usecase.detail.GetMovieDetailUseCaseImpl
import com.example.katas.domain.usecase.detail.recomendations.GetMovieRecomendationsUseCase
import com.example.katas.domain.usecase.detail.recomendations.GetMovieRecomendationsUseCaseImpl
import com.example.katas.domain.usecase.home.popular.GetMoviePopularUseCase
import com.example.katas.domain.usecase.home.popular.GetMoviePopularUseCaseImpl
import com.example.katas.domain.usecase.search.GetMovieSearchUseCase
import com.example.katas.domain.usecase.search.GetMovieSearchUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
 abstract class AppModule {

     // Binds para vincular la implementación a la interfaz abstracta (MovieRepository)
     // comenzamos con el modulo para los detalles y las recomendaciones de la pelicula
     @Binds
     abstract  fun bindMovieRepositoryDetailsAndRecommendations(impl: MovieRepositoryDetailsAndRecommendationsImpl): MovieRepositoryDetailsAndRecommendations

     @Binds
     abstract  fun bindGetMovieDetailUsecase(impl: GetMovieDetailUseCaseImpl): GetMovieDetailUseCase

     @Binds
     abstract fun bindGetMovieRecomendationsUsecase(impl: GetMovieRecomendationsUseCaseImpl): GetMovieRecomendationsUseCase
     // aqui cerramos el modulo para los detalles y las recomendaciones de la pelicula y sus implementaciones

     // comenzamos con el modulo para buscar la pelicula


     @Binds
     abstract  fun bindMovieRepositorySearch(impl: MovieRepositorySearchImpl): MovieRepositorySearch

     @Binds
     abstract  fun bindGetMovieSearchUsecase(impl: GetMovieSearchUseCaseImpl): GetMovieSearchUseCase

     // aqui cerramos el modulo para buscar la pelicula


     // aqui comenzamos con el modulo para las pelicuals populares

     @Binds
     abstract  fun bindMoviesRepositoryPopularAndRated(impl: MovieRepositoryPopularAndRatedImpl): MovieRepositoryPopularAndRated

     @Binds
     abstract fun bindGetMoviePopularUseCase(impl: GetMoviePopularUseCaseImpl): GetMoviePopularUseCase

     // aqui cerramos el modulo para el  peliculas populares



}