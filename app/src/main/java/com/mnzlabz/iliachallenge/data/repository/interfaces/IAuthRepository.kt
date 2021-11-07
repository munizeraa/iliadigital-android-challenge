package com.mnzlabz.iliachallenge.data.repository.interfaces

import com.mnzlabz.iliachallenge.data.model.User
import com.mnzlabz.iliachallenge.data.model.AuthRequest
import com.mnzlabz.iliachallenge.data.model.AuthResponse

interface IAuthRepository {
    suspend fun auth(user: AuthRequest): AuthResponse?
    suspend fun login(token: String): User?
}