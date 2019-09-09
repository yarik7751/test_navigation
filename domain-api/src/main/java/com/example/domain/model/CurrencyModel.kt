package com.example.domain.model

data class CurrencyModel (
    val title: String,
    val purchase: String,
    val sale: String,
    val titleType: Boolean = false
)