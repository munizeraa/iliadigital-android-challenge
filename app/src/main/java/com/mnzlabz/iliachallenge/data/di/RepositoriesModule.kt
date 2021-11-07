package com.mnzlabz.iliachallenge.data.di

import com.mnzlabz.iliachallenge.data.repository.implementations.AuthRepository
import com.mnzlabz.iliachallenge.data.repository.implementations.TeamRepository
import com.mnzlabz.iliachallenge.data.repository.interfaces.IAuthRepository
import com.mnzlabz.iliachallenge.data.repository.interfaces.ITeamRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoriesModule {

    @Binds
    fun providesTeamRepository(teamRepository: TeamRepository) : ITeamRepository

    @Binds
    fun providesAuthRepository(authRepository: AuthRepository) : IAuthRepository
}