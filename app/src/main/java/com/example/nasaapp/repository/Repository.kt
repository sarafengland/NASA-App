package com.example.nasaapp.repository

import com.example.nasaapp.api.RetrofitInstance
import com.example.nasaapp.models.network.NetworkResponse
import java.io.IOException

class Repository {

    suspend fun getCollection(searchQuery: String, mediaType: String): NetworkResponse {
        return try {
            NetworkResponse(
                errorMessage = null,
                responseCollection = RetrofitInstance.api.searchForItems(searchQuery, mediaType)
                    .body()
            )
        } catch (e: IOException) {
            NetworkResponse(
                errorMessage = "IO Exception",
                responseCollection = null
            )
        } catch (e: Throwable) {
            NetworkResponse(
                errorMessage = "Error occurred",
                responseCollection = null
            )
        }
    }
}