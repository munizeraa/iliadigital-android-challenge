package com.mnzlabz.iliachallenge.ui.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mnzlabz.iliachallenge.data.model.AuthRequest
import com.mnzlabz.iliachallenge.data.model.User
import com.mnzlabz.iliachallenge.data.repository.interfaces.IAuthRepository
import com.mnzlabz.iliachallenge.utils.ValidationListener
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(private val authRepository: IAuthRepository): ViewModel() {

    private var _logingStatus = MutableLiveData<ValidationListener>()
    private var _loggedUser = MutableLiveData<User>()

    val loggedUser: LiveData<User> = _loggedUser
    val logingStatus: LiveData<ValidationListener> = _logingStatus

    fun login(userRequest: AuthRequest) {

        viewModelScope.launch(IO) {
            try {
                authRepository.auth(userRequest)?.let {
                    authRepository.login(it.token).let {
                        if (it != null) {
                            _loggedUser.postValue(it)
                            _logingStatus.postValue(ValidationListener())
                        } else {
                            _logingStatus.postValue(ValidationListener("Falha ao autenticar =("))
                        }
                    }

                }

            } catch (exception: Exception) {
                Log.e("ERROR", exception.message.toString())
            }
        }
    }

    fun getLoggedUser(): User {
        return _loggedUser.value as User
    }

}