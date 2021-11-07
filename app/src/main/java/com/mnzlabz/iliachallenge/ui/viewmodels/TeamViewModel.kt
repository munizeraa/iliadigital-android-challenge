package com.mnzlabz.iliachallenge.ui.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mnzlabz.iliachallenge.data.model.Team
import com.mnzlabz.iliachallenge.data.model.User
import com.mnzlabz.iliachallenge.data.model.AuthRequest
import com.mnzlabz.iliachallenge.data.repository.interfaces.IAuthRepository
import com.mnzlabz.iliachallenge.data.repository.interfaces.ITeamRepository
import com.mnzlabz.iliachallenge.utils.ValidationListener
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TeamViewModel @Inject constructor(private val teamRepository: ITeamRepository): ViewModel() {

    private var _teams = MutableLiveData<List<Team>>()
    val teams : LiveData<List<Team>> = _teams

    fun getTeams() {
        viewModelScope.launch(IO) {
            try {
                teamRepository.getTeams().let {
                    _teams.postValue(it ?: arrayListOf())
                }
            } catch(exception: Exception) {
                Log.e("ERROR", exception.message.toString())
            }
        }
    }
}