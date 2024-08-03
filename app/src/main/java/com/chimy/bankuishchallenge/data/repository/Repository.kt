package com.chimy.bankuishchallenge.data.repository

import com.chimy.bankuishchallenge.data.model.RepositoryModel
import com.chimy.bankuishchallenge.data.network.GitHubApiService

class Repository(private val apiService: GitHubApiService) { //obtencion de datos

    // obtener repositorios segun la consulta
    suspend fun getRepositories(query: String, perPage: Int, page: Int): List<RepositoryModel> {
        return try { //llamada a la api
            val response = apiService.getRepositories(query, perPage, page)
            response.items
        } catch (e: Exception) {
            emptyList() //error = lista vacia
        }
    }
}