package com.hbworld.githubcpr.util

import com.hbworld.githubcpr.data.dtos.FetchCPRResponse
import com.hbworld.githubcpr.data.mapper.ClosedPRMapper
import com.hbworld.githubcpr.data.mapper.ListMapper
import com.hbworld.githubcpr.data.remote.GithubAPI
import com.hbworld.githubcpr.data.remote.RetrofitClient
import com.hbworld.githubcpr.data.repository.GithubRepositoryImpl
import com.hbworld.githubcpr.domain.GithubRepository
import com.hbworld.githubcpr.domain.model.ClosedPR
import retrofit2.Retrofit

object DependencyUtil {

    fun getGithubRepository() : GithubRepository{
        return GithubRepositoryImpl(getGithubApi(), getClosedPRMapper())
    }

    private fun getClosedPRMapper(): ListMapper<FetchCPRResponse, ClosedPR> {
        return ClosedPRMapper()
    }

    private fun getGithubApi(): GithubAPI {
        return getRetrofitClient().create(GithubAPI::class.java)
    }

    private fun getRetrofitClient(): Retrofit {
        return RetrofitClient.get()
    }

}