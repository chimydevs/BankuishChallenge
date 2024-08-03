package com.chimy.bankuishchallenge.data.model

import com.google.gson.annotations.SerializedName

data class SearchResponse( //respuesta de la busqueda
    val items: List<RepositoryModel> //lista de repositorios
)
