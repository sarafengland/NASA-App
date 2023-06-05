package com.example.nasaapp.models.nasamodels

import java.io.Serializable

data class ItemLink(
    val href: String?,
    val rel: String?,
    val render: String?
) : Serializable
