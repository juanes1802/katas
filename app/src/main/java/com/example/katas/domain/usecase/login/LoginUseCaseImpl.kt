package com.example.katas.domain.usecase.login

import com.example.katas.data.model.local.entity.User
import com.example.katas.domain.repository.LoginRepository

class LoginUseCaseImpl(private val loginRepository: LoginRepository) : LoginUseCase {
    override suspend fun login(email: String, password: String): User? {
     return loginRepository.loginUser(email,password)
    }

    override fun saveSession(email: String) {
       loginRepository.saveUserSession(email)
    }

    override fun getSession(): String {
      return loginRepository.getUserSession()
    }

    override fun clearSession() {
        loginRepository.clearSession()

    }

}