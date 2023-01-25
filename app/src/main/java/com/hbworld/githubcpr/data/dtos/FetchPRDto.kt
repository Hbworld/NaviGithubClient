package com.hbworld.githubcpr.data.dtos

import com.google.gson.annotations.SerializedName

class FetchPRDto(

    @SerializedName("user")
    val user: GithubUser,

    @SerializedName("title")
    val title: String,

    @SerializedName("number")
    val number: String,

    @SerializedName("created_at")
    val createdAt: String,

    @SerializedName("closed_at")
    val closedAt: String,

    ) : GitHubDto() {

    val simpleCreatedDate: String
        get() = githubToSimpleDate(createdAt)

    val simpleClosedDate: String
        get() = githubToSimpleDate(closedAt)
}


