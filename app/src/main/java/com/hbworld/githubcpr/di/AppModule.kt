package com.hbworld.githubcpr.di

import com.hbworld.githubcpr.data.mapper.ClosedPRMapper
import com.hbworld.githubcpr.data.remote.GithubAPI
import com.hbworld.githubcpr.data.remote.RetrofitClient
import com.hbworld.githubcpr.data.repository.GithubRepositoryImpl
import com.hbworld.githubcpr.domain.GithubRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideGitHubRepository(
        githubAPI: GithubAPI,
    ) : GithubRepository {
        return GithubRepositoryImpl(githubAPI, ClosedPRMapper())
    }

    @Singleton
    @Provides
    fun provideGithubAPI() : GithubAPI{
        return RetrofitClient.get().create(GithubAPI::class.java)
    }

}