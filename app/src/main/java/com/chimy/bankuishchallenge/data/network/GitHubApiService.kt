package com.chimy.bankuishchallenge.data.network

import com.chimy.bankuishchallenge.data.model.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GitHubApiService{ //interfaz para llamadas
    @GET("search/repositories")
    suspend fun getRepositories(
        @Query("q") query: String,//termino d ela busqueda
        @Query("perPage") perPage: Int, //resultados
        @Query("page") page: Int, //numero de pagina
    ): SearchResponse
}

