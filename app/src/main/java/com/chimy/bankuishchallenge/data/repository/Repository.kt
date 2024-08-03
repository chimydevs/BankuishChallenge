package com.chimy.bankuishchallenge.data.repository

import com.chimy.bankuishchallenge.data.model.RepositoryModel
import com.chimy.bankuishchallenge.data.network.GitHubApiService

class Repository(private val apiService: GitHubApiService) {
    suspend fun getRepositories(query: String, perPage: Int, page: Int): List<RepositoryModel> {
        return try {
            val response = apiService.getRepositories(query, perPage, page)
            response.items
        } catch (e: Exception) {
            emptyList()
        }
    }
}