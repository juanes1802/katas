package com.example.katas.domain.usecase.login

import com.example.katas.data.model.local.entity.User

interface LoginUseCase {
    suspend fun  login(email: String, password: String): User?
    fun saveSession(email:String)
    fun getSession(): String
    fun clearSession()

}