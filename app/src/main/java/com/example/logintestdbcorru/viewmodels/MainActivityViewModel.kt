package com.example.logintestdbcorru.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.logintestdbcorru.db.AppRepository
import com.example.logintestdbcorru.db.NacionalidadEntity
import kotlinx.coroutines.launch

class MainActivityViewModel(private val repository: AppRepository) : ViewModel()  {

    val allPaises : LiveData<List<NacionalidadEntity>> = repository.allNacionalidades.asLiveData()

    fun insertNacionalidades(paises: List<NacionalidadEntity>) = viewModelScope.launch {
        repository.insertNacionalidades(paises)
    }

}

class WordViewModelFactory(private val repository: AppRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainActivityViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}