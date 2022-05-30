package com.hbworld.githubcpr.domain

import com.hbworld.githubcpr.domain.model.ClosedPR

interface GitHubRepository {
    suspend fun getAllClosedPR() : Result<List<ClosedPR>>
}