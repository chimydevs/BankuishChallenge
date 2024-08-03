package com.chimy.bankuishchallenge.data.repository

import com.chimy.bankuishchallenge.data.model.RepositoryModel
import com.chimy.bankuishchallenge.data.network.GitHubApiService

//llamados a la api
class Repository(private val apiService: GitHubApiService) {
    suspend fun getRepositories(query: String, perPage: Int, page: Int):List<RepositoryModel>{
        return try { // llamada a a la api
            val response = apiService.getRepositories(query,perPage, page)
            response.items //retorna lista de repositorios
        } catch (
            e:Exception
        ){
            emptyList() //retorna una lista vacia si falla
        }
    }

}