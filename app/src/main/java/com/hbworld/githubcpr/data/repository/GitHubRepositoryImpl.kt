package com.hbworld.githubcpr.data.repository

import com.hbworld.githubcpr.data.dtos.FetchCPRResponse
import com.hbworld.githubcpr.data.mapper.ClosedPRMapper
import com.hbworld.githubcpr.data.remote.GithubAPI
import com.hbworld.githubcpr.domain.GitHubRepository
import com.hbworld.githubcpr.domain.model.ClosedPR

class GitHubRepositoryImpl(
    private val githubAPI: GithubAPI,
) :  BaseRepositoryImpl(), GitHubRepository {

    override suspend fun getAllClosedPR(): Result<List<ClosedPR>> = performAPICall(
        apiCall = { getAllPR() },
        mapper = { ClosedPRMapper.map(it) }
    )

    private suspend fun getAllPR(
        owner: String = "Hbworld",
        repo: String = "NaviGithubClient",
        state: String = "closed",
    ): List<FetchCPRResponse> {
        return githubAPI.fetchPullRequest(
            owner = owner,
            repo = repo,
            state = state
        )
    }


}