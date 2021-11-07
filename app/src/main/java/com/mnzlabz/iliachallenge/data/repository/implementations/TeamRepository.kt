package com.mnzlabz.iliachallenge.data.repository.implementations

import android.util.Log
import com.mnzlabz.iliachallenge.data.model.Team
import com.mnzlabz.iliachallenge.data.remote.interfaces.ITeamService
import com.mnzlabz.iliachallenge.data.repository.interfaces.ITeamRepository
import java.lang.Exception
import javax.inject.Inject

class TeamRepository @Inject constructor(val teamService: ITeamService): ITeamRepository {
    override suspend fun getTeams(): List<Team>? {
        var teams: List<Team>? = null

        try {
            teams = teamService.getAllTeams().body()
        } catch(exception: Exception) {
            Log.e("TEAM REPO", exception.message.toString())
        }

        return teams
    }
}