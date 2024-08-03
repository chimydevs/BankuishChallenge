package com.chimy.bankuishchallenge.data.network

import com.chimy.bankuishchallenge.data.model.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GitHubApiService{
    @GET("search/repositories")
    suspend fun getRepositories(
        @Query("q") query: String,
        @Query("perPage") perPage: Int,
        @Query("page") page: Int,
    ): SearchResponse
}

