package com.example.domain.usecase.login

import com.example.domain.model.UserDomain

import com.example.domain.repository.LoginRepository

class LoginUseCaseImpl(private val loginRepository: LoginRepository) : LoginUseCase {
    override suspend fun login(email: String, password: String): UserDomain? {
     return loginRepository.loginUser(email,password)
    }

    override fun saveSession(email: String ) {
       loginRepository.saveUserSession(email)
    }

    override fun getSession(): String {
      return loginRepository.getUserSession()
    }

    override fun clearSession() {
        loginRepository.clearSession()

    }

}