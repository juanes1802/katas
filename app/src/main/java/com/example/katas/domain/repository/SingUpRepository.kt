package com.example.katas.domain.repository

import com.example.katas.data.model.local.entity.User
import dagger.hilt.android.lifecycle.HiltViewModel


interface SingUpRepository {
    suspend fun  registerUser(name: String, email:String, password: String): User?

}