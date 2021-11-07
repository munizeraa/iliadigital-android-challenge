package com.mnzlabz.iliachallenge.data.remote.interfaces

import com.mnzlabz.iliachallenge.data.model.Team
import retrofit2.Response
import retrofit2.http.GET

interface ITeamService {
    @GET(value = "/teams")
    suspend fun getAllTeams(): Response<List<Team>>

}