package com.example.katas.data.mappers

import com.example.domain.model.UserDomain
import com.example.katas.data.model.local.entity.User
// mapper de userDto a UserDomain
fun User.toDomainModel(): UserDomain {
    return UserDomain(
        id = this.id,
        name = this.name,
        email = this.email,
        password = this.password
    )
}





