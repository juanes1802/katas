package com.example.katas.di

import android.content.Context
import androidx.room.Room
import com.example.katas.data.model.local.AppDatabase
import com.example.katas.data.model.local.dao.MovieDao
import com.example.katas.data.model.local.dao.UserDao
import com.example.katas.data.repository.LoginRepositoryImpl
import com.example.katas.data.repository.SingUpRepositoryImpl
import com.example.katas.data.sharedpreference.Prefs
import com.example.katas.domain.repository.LoginRepository
import com.example.katas.domain.repository.SingUpRepository
import com.example.katas.domain.usecase.login.LoginUseCase
import com.example.katas.domain.usecase.login.LoginUseCaseImpl
import com.example.katas.domain.usecase.singup.SignUpUseCase
import com.example.katas.domain.usecase.singup.SignUpUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase{
        return  Room.databaseBuilder(
            context,AppDatabase::class.java,
            "app_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideMovieDao(database: AppDatabase): MovieDao {
        return database.MovieDao()



    }

    @Provides
    @Singleton
    fun provideUserDao(database: AppDatabase): UserDao {
        return database.UserDao()
    }
    @Provides
    @Singleton
    fun providePrefs(@ApplicationContext context: Context): Prefs {
        return Prefs(context)
    }


    @Provides
    @Singleton
    fun provideLoginRepository(userDao: UserDao,prefs: Prefs): LoginRepository {
        return LoginRepositoryImpl(userDao,prefs)
    }

    @Provides
    @Singleton
    fun provideLoginUseCase(loginRepository: LoginRepository): LoginUseCase {
        return LoginUseCaseImpl(loginRepository)
    }
    @Provides
    @Singleton
    fun provideSingUpRepository(userDao: UserDao): SingUpRepository  {
        return SingUpRepositoryImpl(userDao)

    }
    @Provides
    @Singleton
    fun provideSingUpUseCase(singUpRepository: SingUpRepository): SignUpUseCase {
        return SignUpUseCaseImpl(singUpRepository)
    }



}