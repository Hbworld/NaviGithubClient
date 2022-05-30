package com.hbworld.githubcpr.domain

import com.hbworld.githubcpr.domain.model.ClosedPR


interface GithubUseCase {
    suspend fun getAllClosedPRs(): Result<List<ClosedPR>>

    class Impl(private val gitHubRepository: GitHubRepository) : GithubUseCase {

        override suspend fun getAllClosedPRs(): Result<List<ClosedPR>> {
            return gitHubRepository.getAllClosedPR()
        }

    }
}