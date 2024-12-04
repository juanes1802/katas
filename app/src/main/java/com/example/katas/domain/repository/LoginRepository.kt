package com.example.katas.domain.repository

import com.example.katas.data.model.local.entity.User

interface LoginRepository {
    suspend fun  loginUser(email: String, password: String): User?
    fun saveUserSession(email: String)
    fun getUserSession(): String
    fun clearSession()
}