package com.hbworld.githubcpr.domain

import com.hbworld.githubcpr.domain.model.ClosedPR


interface GithubRepository {
    suspend fun getAllClosedPRs(): List<ClosedPR>
}