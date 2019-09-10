package com.example.presentation_api

data class CurrencyPresentationModel (
    val title: String,
    val purchase: String,
    val sale: String,
    val titleType: Boolean = false
)