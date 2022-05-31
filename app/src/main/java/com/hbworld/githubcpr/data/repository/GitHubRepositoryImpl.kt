package com.hbworld.githubcpr.data.repository

import com.hbworld.githubcpr.data.dtos.FetchPRDto
import com.hbworld.githubcpr.data.mapper.GithubMapper
import com.hbworld.githubcpr.data.remote.GithubAPI
import com.hbworld.githubcpr.domain.GitHubRepository
import com.hbworld.githubcpr.domain.model.ClosedPR
import com.hbworld.githubcpr.domain.model.Results

class GitHubRepositoryImpl(
    private val githubAPI: GithubAPI,
    private val githubMapper: GithubMapper
) : BaseRepositoryImpl(), GitHubRepository {

    override suspend fun getAllClosedPR(): Results<List<ClosedPR>> = performAPICall(
        apiCall = { getAllPR() },
        mapper = { githubMapper.mapToClosedPR(it) }
    )

    private suspend fun getAllPR(
        owner: String = "Hbworld",
        repo: String = "NaviGithubClient",
        state: String = "closed",
    ): List<FetchPRDto> = githubAPI.fetchPullRequest(
        owner = owner,
        repo = repo,
        state = state
    )
}