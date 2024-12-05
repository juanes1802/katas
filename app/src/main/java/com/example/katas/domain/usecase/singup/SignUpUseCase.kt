package com.example.katas.domain.usecase.singup

import com.example.katas.data.model.local.entity.User

interface SignUpUseCase {
    suspend fun  registerUser(name: String, email:String, password: String): User?
}