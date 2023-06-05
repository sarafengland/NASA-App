package com.example.nasaapp.models.nasamodels

import java.io.Serializable

data class NasaObject(
    val version: String?,
    val href: String?,
    val items: List<Item>
) : Serializable
