package com.example.domain

import com.example.domain.model.CurrencyModel

interface CurrenciesInteractor {

    suspend fun getCurrenciesAsync(): List<CurrencyModel>
}