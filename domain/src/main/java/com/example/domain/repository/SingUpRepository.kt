package com.example.domain.repository

import com.example.domain.model.UserDomain


interface SingUpRepository {
    suspend fun  registerUser(name: String, email:String, password: String): UserDomain?

}