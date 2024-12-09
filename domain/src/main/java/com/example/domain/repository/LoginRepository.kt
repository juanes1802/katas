package com.example.domain.repository

import com.example.domain.model.UserDomain


interface LoginRepository {
    suspend fun  loginUser(email: String, password: String): UserDomain?
    fun saveUserSession(email: String)
    fun getUserSession(): String
    fun clearSession()
}