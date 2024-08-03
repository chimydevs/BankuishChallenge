package com.chimy.bankuishchallenge.data.model

import com.google.gson.annotations.SerializedName

data class RepositoryModel(
    @SerializedName("name") val name: String,
    @SerializedName("owner") val owner: RepositoryOwner
) {
    data class RepositoryOwner(
        @SerializedName("login") val login: String
    )
}
