package com.example.common

import com.example.common.network.RestApi
import com.example.domain.CurrenciesInteractor
import com.example.domain.repository.CurrenciesRepository
import com.example.navigation_api.NavigationCommands
import com.example.navigation_api.NavigationInit

interface AppProvider {

    fun provideRemoteDataStore(): RestApi

    fun navigationInit(): NavigationInit

    fun navigationCommands(): NavigationCommands

    fun provideCurrenciesRepository(): CurrenciesRepository

    fun provideCurrenciesInteractor(): CurrenciesInteractor
}