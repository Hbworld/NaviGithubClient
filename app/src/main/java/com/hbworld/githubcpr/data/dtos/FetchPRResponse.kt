package com.hbworld.githubcpr.data.dtos

import com.google.gson.annotations.SerializedName

class FetchCPRResponse(

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

    )


class GithubUser(

    @SerializedName("login")
     val login: String,

    @SerializedName("avatar_url")
     val avatarUrl: String
)