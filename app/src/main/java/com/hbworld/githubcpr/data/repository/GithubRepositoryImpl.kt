package com.hbworld.githubcpr.data.repository

import com.hbworld.githubcpr.data.mapper.ListMapper
import com.hbworld.githubcpr.data.remote.GithubAPI
import com.hbworld.githubcpr.domain.GithubRepository
import com.hbworld.githubcpr.domain.model.ClosedPR
import com.hbworld.githubcpr.data.dtos.FetchCPRResponse

class GithubRepositoryImpl(
    private val githubAPI: GithubAPI,
    private val closedPRMapper: ListMapper<FetchCPRResponse, ClosedPR>
) : GithubRepository {

    override suspend fun getAllClosedPRs(): List<ClosedPR> {
        return closedPRMapper.map(getAllPR())
    }


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