package com.mnzlabz.iliachallenge.data.remote.interfaces

import com.mnzlabz.iliachallenge.data.model.AuthResponse
import com.mnzlabz.iliachallenge.data.model.User
import com.mnzlabz.iliachallenge.data.model.AuthRequest
import retrofit2.Response
import retrofit2.http.*

interface IAuthService {
    @GET(value = "/login")
    suspend fun login(@Header("token") token: String): Response<User>

    @POST(value = "/auth")
    suspend fun auth(@Body user: AuthRequest): Response<AuthResponse>
}