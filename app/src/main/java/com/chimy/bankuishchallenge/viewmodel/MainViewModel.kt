package com.chimy.bankuishchallenge.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chimy.bankuishchallenge.data.model.RepositoryModel
import com.chimy.bankuishchallenge.data.repository.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

//viewmodel estado y logica de ui
class MainViewModel(private val repository: Repository) : ViewModel() {

    //lista de repositorios
    private val _repositories = MutableStateFlow<List<RepositoryModel>>(emptyList())
    val repositories: StateFlow<List<RepositoryModel>> get() = _repositories

    //carga
    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> get() = _loading

    //mensaje de error
    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> get() = _error

    fun fetchRepositories() { //obtener lista de repositorios
        viewModelScope.launch {
            _loading.value = true
            try { //llamada al repo y obtencion de de datos
                _repositories.value = repository.getRepositories("language:kotlin", 30, 1)
            } catch (e: Exception) { //si hay un error
                _error.value = e.message
            } finally { // termina la carga
                _loading.value = false
            }
        }
    }
}