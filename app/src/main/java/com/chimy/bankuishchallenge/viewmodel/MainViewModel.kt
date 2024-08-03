package com.chimy.bankuishchallenge.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chimy.bankuishchallenge.data.model.RepositoryModel
import com.chimy.bankuishchallenge.data.repository.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

//viewmodel estado y logica de ui
class MainViewModel(private val repository: Repository): ViewModel() {
    private val _repositories = MutableStateFlow<List<RepositoryModel>>(emptyList())
    val repositories: StateFlow<List<RepositoryModel>> get() = _repositories

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> get() = _loading

    private val _error = MutableStateFlow(null)
    val error: StateFlow<String?> get() = _error

    fun fetchRepositories(){
        viewModelScope.launch {
            _loading.value = true
            try {
                _repositories.value = repository.getRepositories("language:kotlin",30,1)
            }catch (e: Exception){
                _error.value = e.message as Nothing?
            } finally {
                _loading.value = false
            }
        }
    }
}