package com.example.data.repository

import com.example.domain.model.UserDomain
import com.example.data.model.local.dao.UserDao

import com.example.domain.repository.LoginRepository
import com.example.data.mappers.toDomainModel
import com.example.data.sharedpreference.Prefs
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(private  val userDao: UserDao,
                                              private val prefs: Prefs
): LoginRepository {
    override suspend fun loginUser(email: String, password: String): UserDomain? {
        return userDao.loginUser(email,password)?.toDomainModel()
    }

    override fun saveUserSession(email: String) {
       prefs.saveName(email)
    }

    override fun getUserSession(): String {
        return prefs.getName()
    }

    override fun clearSession() {
      prefs.clearSession()
    }
}