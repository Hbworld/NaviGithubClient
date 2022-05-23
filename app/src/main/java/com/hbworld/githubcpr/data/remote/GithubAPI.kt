package com.hbworld.githubcpr.data.remote

import com.hbworld.githubcpr.data.model.FetchCPRResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubAPI  {

    @GET("repos/{owner}/{repo}/pulls")
    suspend fun fetchPullRequest(
        @Path("owner") owner : String,
        @Path("repo") repo : String,
        @Query("state") state : String) : List<FetchCPRResponse>


}