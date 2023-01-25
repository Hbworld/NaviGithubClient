package com.hbworld.githubcpr.di

import com.hbworld.githubcpr.data.mapper.GitHubMapperImpl
import com.hbworld.githubcpr.data.mapper.GithubMapper
import com.hbworld.githubcpr.data.remote.GithubAPI
import com.hbworld.githubcpr.data.remote.RetrofitClient
import com.hbworld.githubcpr.data.repository.GitHubRepositoryImpl
import com.hbworld.githubcpr.domain.GitHubRepository
import com.hbworld.githubcpr.domain.GithubUseCase
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
    fun provideGitHubUseCase(
        gitHubRepository: GitHubRepository
    ) : GithubUseCase {
        return GithubUseCase.Impl(gitHubRepository)
    }

    @Singleton
    @Provides
    fun provideGitHubRepository(
        githubAPI: GithubAPI,
        githubMapper: GithubMapper
    ) : GitHubRepository {
        return GitHubRepositoryImpl(githubAPI, githubMapper)
    }

    @Singleton
    @Provides
    fun provideGithubAPI() : GithubAPI{
        return RetrofitClient.get().create(GithubAPI::class.java)
    }

    @Singleton
    @Provides
    fun provideGithubMapper() : GithubMapper{
        return GitHubMapperImpl()
    }

}