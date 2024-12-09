package com.example.domain.usecase.login

import com.example.domain.model.UserDomain


interface LoginUseCase {
    suspend fun  login(email: String, password: String): UserDomain?
    fun saveSession(email:String)
    fun getSession(): String
    fun clearSession()

}