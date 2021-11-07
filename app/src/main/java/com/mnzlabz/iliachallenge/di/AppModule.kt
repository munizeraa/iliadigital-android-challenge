package com.mnzlabz.iliachallenge.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.mnzlabz.iliachallenge.data.remote.interfaces.IAuthService
import com.mnzlabz.iliachallenge.data.remote.interfaces.ITeamService
import com.mnzlabz.iliachallenge.data.repository.implementations.AuthRepository
import com.mnzlabz.iliachallenge.data.repository.implementations.TeamRepository
import com.mnzlabz.iliachallenge.data.repository.interfaces.IAuthRepository
import com.mnzlabz.iliachallenge.data.repository.interfaces.ITeamRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    var interceptor = HttpLoggingInterceptor().apply {
        this.level = HttpLoggingInterceptor.Level.BODY
    }

    var client = OkHttpClient.Builder().apply {
        this.addInterceptor(interceptor)
    }.build()

    @Singleton
    @Provides
    fun providesTeamService(retrofit: Retrofit) : ITeamService = retrofit.create(ITeamService::class.java)

    @Singleton
    @Provides
    fun providesAuthService(retrofit: Retrofit) : IAuthService = retrofit.create(IAuthService::class.java)

    @Singleton
    @Provides
    fun providesRetrofit(gson: Gson) : Retrofit = Retrofit.Builder()
        .baseUrl("https://c526ee5a-a2fb-446c-b242-d5fa13592a1a.mock.pstmn.io/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(client)
        .build()

    @Singleton
    @Provides
    fun providesGson(): Gson = GsonBuilder().create()
}
