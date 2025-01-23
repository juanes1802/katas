package com.example.domain.usecase.login

import com.example.domain.model.UserDomain


interface LoginUseCase {
    suspend fun  login(email: String, password: String): UserDomain?
     suspend fun saveSession(email:String)
    fun getSession(): String
    suspend fun  getUserByEmail(email: String): UserDomain?
    fun clearSession()

}