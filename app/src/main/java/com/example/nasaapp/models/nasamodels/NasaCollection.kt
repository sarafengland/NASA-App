package com.example.nasaapp.models.nasamodels

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class NasaCollection(
    @SerializedName("collection")
    val nasaCollection: NasaObject?,
) : Serializable
