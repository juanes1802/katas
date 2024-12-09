package com.example.domain.usecase.singup

import com.example.domain.model.UserDomain
import com.example.domain.repository.SingUpRepository

class SignUpUseCaseImpl(private val singUpRepository: SingUpRepository) : SignUpUseCase {
    override suspend fun registerUser(name: String, email: String, password: String): UserDomain? {
     return  singUpRepository.registerUser(name,email,password)

    }
}