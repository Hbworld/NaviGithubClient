package com.hbworld.githubcpr.data.mapper

import com.hbworld.githubcpr.util.DateUtil
import com.hbworld.githubcpr.domain.model.ClosedPR
import com.hbworld.githubcpr.data.dtos.FetchCPRResponse

class ClosedPRMapper : ListMapper<FetchCPRResponse, ClosedPR> {
    override fun map(input: List<FetchCPRResponse>): List<ClosedPR> {
        return input.map {
                ClosedPR(
                    title = it.title,
                    createdAt = DateUtil.formatGithubDateToSimple(it.createdAt),
                    closedAt = DateUtil.formatGithubDateToSimple(it.closedAt),
                    id = it.number,
                    author = it.user.login,
                    authorImage = it.user.avatarUrl,
                )
        }
    }
}