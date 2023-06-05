package com.example.nasaapp.repository

import com.example.nasaapp.api.RetrofitInstance
import com.example.nasaapp.models.NasaCollection

class Repository {

    suspend fun getCollection(searchQuery: String, mediaType: String) : NasaCollection? {
        return RetrofitInstance.api.searchForItems(searchQuery, mediaType).body()
    }
}