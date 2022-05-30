package com.hbworld.githubcpr.domain

import com.hbworld.githubcpr.domain.model.ClosedPR
import com.hbworld.githubcpr.domain.model.Results

interface GitHubRepository {
    suspend fun getAllClosedPR() : Results<List<ClosedPR>>
}