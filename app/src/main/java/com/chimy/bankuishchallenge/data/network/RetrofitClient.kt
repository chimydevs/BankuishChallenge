package com.chimy.bankuishchallenge.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient { //servicio ed api con retro
    private const val BASE_URL = "https://api.github.com/"

    val apiService: GitHubApiService by lazy { //inicializacion del servicio
        Retrofit.Builder()
            .baseUrl(BASE_URL)//url base
            .addConverterFactory(GsonConverterFactory.create())//json a objetos
            .build()
            .create(GitHubApiService::class.java) //instancia
    }
}