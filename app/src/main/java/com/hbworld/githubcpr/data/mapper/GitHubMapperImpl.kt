package com.hbworld.githubcpr.data.mapper

import com.hbworld.githubcpr.data.dtos.FetchPRDto
import com.hbworld.githubcpr.domain.model.ClosedPR
import com.hbworld.githubcpr.domain.model.Results

class GitHubMapperImpl : GithubMapper {

    override fun mapToClosedPR(input: List<FetchPRDto>): Results<List<ClosedPR>> = try {
        mapToResult(input.map {
            getClosedPR(it)
        })
    } catch (e: Exception) {
        Results.error(e.toString())
    }


    private fun getClosedPR(input: FetchPRDto): ClosedPR = ClosedPR(
        title = input.title,
        createdAt = input.simpleCreatedDate,
        closedAt = input.simpleClosedDate,
        id = input.number,
        author = input.user.login,
        authorImage = input.user.avatarUrl,
    )


    private fun <T> mapToResult(input: T): Results<T> = Results.success(input)


}