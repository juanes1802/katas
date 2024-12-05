package com.example.katas.data.repository

import com.example.katas.data.model.local.dao.UserDao
import com.example.katas.data.model.local.entity.User
import com.example.katas.domain.repository.SingUpRepository
import javax.inject.Inject

class SingUpRepositoryImpl @Inject constructor(private val userDao:UserDao):SingUpRepository {
    override suspend fun registerUser(name: String, email: String, password: String): User? {
        val user = User(name = name, email = email, password = password)
      userDao.registerUser(user)
        return user

    }

}