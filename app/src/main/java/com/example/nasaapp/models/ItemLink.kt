package com.example.nasaapp.models

import java.io.Serializable

data class ItemLink(
    val href: String?,
    val rel: String?,
    val render: String?
) : Serializable
