package com.hbworld.githubcpr.data.mapper

import com.hbworld.githubcpr.data.dtos.FetchCPRResponse
import com.hbworld.githubcpr.domain.model.ClosedPR
import com.hbworld.githubcpr.domain.model.Results

interface GithubMapper {
    fun mapToClosedPR(input : List<FetchCPRResponse>) : Results<List<ClosedPR>>
}