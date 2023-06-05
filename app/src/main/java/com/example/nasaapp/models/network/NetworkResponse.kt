package com.example.nasaapp.models.network

import com.example.nasaapp.models.nasamodels.NasaCollection
import java.io.Serializable

data class NetworkResponse(
    val errorMessage: String?,
    val responseCollection: NasaCollection?
) : Serializable
