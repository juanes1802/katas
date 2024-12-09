package com.example.katas.data.repository

import com.example.domain.model.UserDomain
import com.example.katas.data.model.local.dao.UserDao
import com.example.katas.data.model.local.entity.User
import com.example.domain.repository.SingUpRepository
import com.example.katas.data.mappers.toDomainModel
import javax.inject.Inject

class SingUpRepositoryImpl @Inject constructor(private val userDao:UserDao): SingUpRepository {
    override suspend fun registerUser(name: String, email: String, password: String): UserDomain? {
        val user = User(name = name, email = email, password = password)
      userDao.registerUser(user)
        return user.toDomainModel()

    }

}