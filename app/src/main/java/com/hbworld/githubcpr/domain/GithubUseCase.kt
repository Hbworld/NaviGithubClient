package com.hbworld.githubcpr.domain

import com.hbworld.githubcpr.domain.model.ClosedPR
import com.hbworld.githubcpr.domain.model.Results


interface GithubUseCase {
    suspend fun getAllClosedPRs(): Results<List<ClosedPR>>

    class Impl(private val gitHubRepository: GitHubRepository) : GithubUseCase {

        override suspend fun getAllClosedPRs(): Results<List<ClosedPR>> {
            return gitHubRepository.getAllClosedPR()
        }

    }
}