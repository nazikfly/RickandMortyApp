package com.geektech.rickandmortyapp.api

import com.geektech.rickandmortyapp.api.model.CharacterList
import retrofit2.Response
import retrofit2.http.Query

class Repository {

    suspend fun getCharacters(page: Int): Response<CharacterList> {
        return RetrofitInstance.api.getCharacter(page)

    }

    suspend fun getCharactersByStatusAndGender(
        status: String,
        gender: String,
        page: Int
    ): Response<CharacterList> {
        return RetrofitInstance.api.getCharactersByStatusAndGender(status, gender, page)
    }

    suspend fun getCharactersByStatus(status: String, page: Int): Response<CharacterList> {
        return RetrofitInstance.api.getCharactersByStatus(status, page)
    }

    suspend fun getCharactersByGender(
        gender: String,
        page: Int
    ): Response<CharacterList> {
        return RetrofitInstance.api.getCharactersByGender(gender, page)
    }
}


