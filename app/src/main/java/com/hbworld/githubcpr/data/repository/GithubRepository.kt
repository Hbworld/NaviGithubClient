package com.hbworld.githubcpr.data.repository

import com.hbworld.githubcpr.data.model.FetchCPRResponse
import com.hbworld.githubcpr.data.remote.GithubAPI

class GithubRepository(private val githubAPI: GithubAPI) {

    suspend fun getAllClosedPR(
        owner: String = "linkedin",
        repo: String = "LiTr",
        state: String = "closed",
    ): List<FetchCPRResponse> {
        return githubAPI.fetchPullRequest(
            owner = owner,
            repo = repo,
            state = state
        )
    }


}