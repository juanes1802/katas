package com.example.domain.usecase.singup

import com.example.domain.model.UserDomain


interface SignUpUseCase {
    suspend fun  registerUser(name: String, email:String, password: String): UserDomain?
}