package com.example.nasaapp.models

import java.io.Serializable

data class Item(
    val href: String?,
    val data: List<ItemData>?,
    val links: List<ItemLink>?
) : Serializable
