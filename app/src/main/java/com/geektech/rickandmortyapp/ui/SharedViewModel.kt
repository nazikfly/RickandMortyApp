package com.geektech.rickandmortyapp.ui

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.geektech.rickandmortyapp.api.model.CharacterList
import com.geektech.rickandmortyapp.api.Repository
import com.geektech.rickandmortyapp.api.RetrofitInstance
import kotlinx.coroutines.launch
import retrofit2.Response

class SharedViewModel(val repository: Repository):ViewModel() {

    var listCharacters = MediatorLiveData<Response<CharacterList>>()
    var filterValue=MediatorLiveData<Array<Int>>()

    init {
        filterValue.value= arrayOf(0,0)
    }

    fun getCharacters(page: Int) {
        viewModelScope.launch {
            val character = repository.getCharacters(page)
            listCharacters.value = character
        }
    }

    fun getByStatusAndGender(status: String, gender: String, page: Int) {
        viewModelScope.launch {
            val character = repository.getCharactersByStatusAndGender(status, gender, page)
            listCharacters.value = character
        }
    }

    fun getByStatus(status: String,  page: Int) {
        viewModelScope.launch {
            val character = repository.getCharactersByStatus(status, page)
            listCharacters.value = character
        }
    }
    fun getByGender( gender: String, page: Int) {
        viewModelScope.launch {
            val character = repository.getCharactersByGender( gender, page)
            listCharacters.value = character
        }
    }
}