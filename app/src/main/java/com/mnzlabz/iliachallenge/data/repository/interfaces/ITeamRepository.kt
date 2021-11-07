package com.mnzlabz.iliachallenge.data.repository.interfaces

import com.mnzlabz.iliachallenge.data.model.Team
import dagger.Binds
import retrofit2.Response

interface ITeamRepository {
    suspend fun getTeams(): List<Team>?
}
