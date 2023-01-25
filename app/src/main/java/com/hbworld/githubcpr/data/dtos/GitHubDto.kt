package com.hbworld.githubcpr.data.dtos

import com.google.gson.annotations.SerializedName
import com.hbworld.githubcpr.util.DateUtil
import java.util.*

abstract class GitHubDto {

    companion object {
        private const val GITHUB_DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ssXXX"
        private const val SIMPLE_DATE_PATTERN = "dd MMM yy "
    }

    fun githubToSimpleDate(input: String): String {
        val date = parseGithubDate(input)
        if (date != null) return formatSimpleDate(date)
        return ""
    }

    private fun formatSimpleDate(date: Date): String {
        return DateUtil.formatDate(SIMPLE_DATE_PATTERN, date, Locale.ENGLISH)
    }

    private fun parseGithubDate(dateString: String): Date? {
        return DateUtil.parseDate(GITHUB_DATE_PATTERN, dateString, Locale.ENGLISH)
    }

    class GithubUser(

        @SerializedName("login")
        val login: String,

        @SerializedName("avatar_url")
        val avatarUrl: String
    )
}