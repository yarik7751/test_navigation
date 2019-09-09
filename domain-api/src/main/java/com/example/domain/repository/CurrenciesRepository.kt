package com.example.domain.repository

import com.example.domain.model.CurrencyModel

interface CurrenciesRepository {

    suspend fun getCurrenciesAsync(): List<CurrencyModel>
}