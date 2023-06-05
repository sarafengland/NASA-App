package com.example.nasaapp.api

import com.example.nasaapp.models.nasamodels.NasaCollection
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NasaApi {

    @GET("search")
    suspend fun searchForItems(
        @Query("q")
        searchQuery: String,
        @Query("media_type")
        mediaType: String
    ): Response<NasaCollection>
}