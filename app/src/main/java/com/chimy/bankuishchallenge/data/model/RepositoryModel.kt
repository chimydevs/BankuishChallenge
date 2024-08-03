package com.chimy.bankuishchallenge.data.model

import com.google.gson.annotations.SerializedName

data class RepositoryModel( //data class para repo
    @SerializedName("name") val name: String, //nombre
    @SerializedName("owner") val owner: RepositoryOwner //owner del repo
) {
    data class RepositoryOwner( // propietario del repo
        @SerializedName("login") val login: String //nombre de usuario github
    )
}
