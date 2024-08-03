package com.chimy.bankuishchallenge.data.model

import com.google.gson.annotations.SerializedName

data class RepositoryModel( //data class para representar un repo
    @SerializedName("name") val name: String, //nombre del repo
    @SerializedName("owner") val owner: RepositoryOwner //dueño del repo
) {
    data class RepositoryOwner( //representar el propietario
        @SerializedName("login") val login: String, //nombre del usuario
    )
}
