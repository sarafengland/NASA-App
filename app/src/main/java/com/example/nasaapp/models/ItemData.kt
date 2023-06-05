package com.example.nasaapp.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.Date

data class ItemData(
    val album: List<String>?,
    val center: String?,
    val title: String?,
    val photographer: String?,
    val keywords: List<String>?,
    val location: String?,
    @SerializedName("nasa_id")
    val nasaId: String?,
    @SerializedName("date_created")
    val dateCreated: Date?,
    @SerializedName("media_type")
    val mediaType: String?,
    val description: String?
) : Serializable
