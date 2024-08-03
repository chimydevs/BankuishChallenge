package com.chimy.bankuishchallenge.di

import com.chimy.bankuishchallenge.data.network.RetrofitClient
import com.chimy.bankuishchallenge.data.repository.Repository
import com.chimy.bankuishchallenge.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { RetrofitClient.apiService } //inyeccion de la api

    single { Repository(get()) } //repositorio

    viewModel { MainViewModel(get()) } //viewmodel
}