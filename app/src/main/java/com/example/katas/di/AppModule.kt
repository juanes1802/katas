package com.example.katas.di

import android.content.Context
import com.example.katas.data.model.local.AppDatabase
import com.example.katas.data.model.local.dao.MovieDao
import com.example.katas.data.network.ApiInterfaceBuscar
import com.example.katas.data.network.ApiInterfaceDetalle
import com.example.katas.data.network.ApiInterfaceTopRatingAndPopular
import com.example.katas.data.repository.LoginRepositoryImpl
import com.example.katas.data.repository.MovieRepositoryDetailsAndRecommendationsImpl
import com.example.katas.data.repository.MovieRepositoryPopularAndRatedImpl
import com.example.katas.data.repository.MovieRepositorySearchImpl
import com.example.katas.domain.repository.LoginRepository
import com.example.katas.domain.repository.MovieRepositoryDetailsAndRecommendations
import com.example.katas.domain.repository.MovieRepositoryPopularAndRated
import com.example.katas.domain.repository.MovieRepositorySearch
import com.example.katas.domain.usecase.detail.GetMovieDetailUseCase
import com.example.katas.domain.usecase.detail.GetMovieDetailUseCaseImpl
import com.example.katas.domain.usecase.detail.recomendations.GetMovieRecomendationsUseCase
import com.example.katas.domain.usecase.detail.recomendations.GetMovieRecomendationsUseCaseImpl
import com.example.katas.domain.usecase.home.popular.GetMoviePopularUseCase
import com.example.katas.domain.usecase.home.popular.GetMoviePopularUseCaseImpl
import com.example.katas.domain.usecase.home.rated.GetMovieRatedUseCase
import com.example.katas.domain.usecase.home.rated.GetMovieRatedUseCaseImpl
import com.example.katas.domain.usecase.login.LoginUseCase
import com.example.katas.domain.usecase.login.LoginUseCaseImpl
import com.example.katas.domain.usecase.search.GetMovieSearchUseCase
import com.example.katas.domain.usecase.search.GetMovieSearchUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // Proporcionar MovieRepositoryDetailsAndRecommendations
    @Provides
    fun provideMovieRepositoryDetailsAndRecommendations(apiService: ApiInterfaceDetalle): MovieRepositoryDetailsAndRecommendations {
        return MovieRepositoryDetailsAndRecommendationsImpl(apiService)
    }

    // Proporcionar GetMovieDetailUseCase
    @Provides
    fun provideGetMovieDetailUseCase(movieRepository: MovieRepositoryDetailsAndRecommendations): GetMovieDetailUseCase {
        return GetMovieDetailUseCaseImpl(movieRepository)
    }

    // Proporcionar GetMovieRecomendationsUseCase
    @Provides
    fun provideGetMovieRecomendationsUseCase(movieRepository: MovieRepositoryDetailsAndRecommendations): GetMovieRecomendationsUseCase {
        return GetMovieRecomendationsUseCaseImpl(movieRepository)
    }

    // Proporcionar MovieRepositorySearch
    @Provides
    fun provideMovieRepositorySearch(apiService: ApiInterfaceBuscar): MovieRepositorySearch {
        return MovieRepositorySearchImpl(apiService)
    }

    // Proporcionar GetMovieSearchUseCase
    @Provides
    fun provideGetMovieSearchUseCase(movieRepository: MovieRepositorySearch): GetMovieSearchUseCase {
        return GetMovieSearchUseCaseImpl(movieRepository)
    }

    // Proporcionar MovieRepositoryPopularAndRated
    @Provides
    fun provideMovieRepositoryPopularAndRated(apiService: ApiInterfaceTopRatingAndPopular,movieDao: MovieDao): MovieRepositoryPopularAndRated {
        return MovieRepositoryPopularAndRatedImpl(apiService,movieDao)
    }

    // Proporcionar GetMoviePopularUseCase
    @Provides
    fun provideGetMoviePopularUseCase(movieRepository: MovieRepositoryPopularAndRated): GetMoviePopularUseCase {
        return GetMoviePopularUseCaseImpl(movieRepository)
    }

    // Proporcionar GetMovieRatedUseCase
    @Provides
    fun provideGetMovieRatedUseCase(movieRepository: MovieRepositoryPopularAndRated): GetMovieRatedUseCase {
        return GetMovieRatedUseCaseImpl(movieRepository)
    }

}
