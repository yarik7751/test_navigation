package com.example.presentation.fragments.main.currencies.model

data class CurrencyPresentationModel (
    val title: String,
    val purchase: String,
    val sale: String,
    val titleType: Boolean = false
)