package com.example.katas.domain.usecase.singup

import com.example.katas.data.model.local.entity.User
import com.example.katas.domain.repository.SingUpRepository

class SignUpUseCaseImpl(private val singUpRepository: SingUpRepository) : SignUpUseCase {
    override suspend fun registerUser(name: String, email: String, password: String): User? {
     return  singUpRepository.registerUser(name,email,password)

    }
}