package com.example.katas.data.repository

import com.example.katas.data.model.local.dao.UserDao
import com.example.katas.data.model.local.entity.User
import com.example.katas.data.sharedpreference.Prefs
import com.example.katas.domain.repository.LoginRepository
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(private  val userDao: UserDao,
    private val prefs: Prefs
):LoginRepository {
    override suspend fun loginUser(email: String, password: String): User? {
        return userDao.loginUser(email,password)
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