package com.hbworld.githubcpr.data.repository

abstract class BaseRepositoryImpl {

    suspend fun <T, A> performAPICall(
        apiCall: suspend () -> T,
        mapper: (T) -> Result<List<A>>,
    ): Result<List<A>> {
        return mapper(apiCall.invoke())
    }
}