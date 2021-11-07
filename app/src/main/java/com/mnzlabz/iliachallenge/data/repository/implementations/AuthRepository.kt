package com.mnzlabz.iliachallenge.data.repository.implementations

import android.util.Log
import com.mnzlabz.iliachallenge.data.model.User
import com.mnzlabz.iliachallenge.data.model.AuthRequest
import com.mnzlabz.iliachallenge.data.model.AuthResponse
import com.mnzlabz.iliachallenge.data.remote.interfaces.IAuthService
import com.mnzlabz.iliachallenge.data.repository.interfaces.IAuthRepository
import javax.inject.Inject

class AuthRepository @Inject constructor(val authService: IAuthService): IAuthRepository {
    companion object {
        val TAG = "AUTHSERVICE"
    }
    override suspend fun auth(user: AuthRequest): AuthResponse? {
        var response: AuthResponse? = null

        try {
            response = authService.auth(user).body()
        } catch (exception: Exception) {
            Log.e(TAG, exception.message.toString())
        }

        return response
    }

    override suspend fun login(token: String): User? {
        var user: User? = null

        try {
            user = authService.login(token).body()
        } catch (exception: Exception) {
            Log.e(TAG, exception.message.toString())
        }
        return user
    }
}
