package com.hbworld.githubcpr.data.repository

import com.hbworld.githubcpr.domain.model.Results

abstract class BaseRepositoryImpl {

    suspend fun <T, A> performAPICall(
        apiCall: suspend () -> T,
        mapper: (T) -> Results<List<A>>,
    ): Results<List<A>> {
        return try {
            mapper(apiCall.invoke())
        }catch (e :Exception){
            return Results.error(e.toString())
        }
    }
}