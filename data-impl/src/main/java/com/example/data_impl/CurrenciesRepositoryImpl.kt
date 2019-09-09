package com.example.data_impl

import com.example.common.mapper.CurrenciesMapper
import com.example.common.network.RestApi
import com.example.data_impl.base.BaseRepository
import com.example.domain.model.CurrencyModel
import com.example.domain.repository.CurrenciesRepository
import javax.inject.Inject

class CurrenciesRepositoryImpl @Inject constructor(
    val respApi: RestApi
) : BaseRepository(), CurrenciesRepository {

    override suspend fun getCurrenciesAsync(): List<CurrencyModel> {
        val currenciesResponse = safeApiCall(
            call = { respApi.getCurrenciesAsync().await() },
            errorMessage = "Error Fetching Currencies"
        )

        val returnList = currenciesResponse ?: emptyList()
        return CurrenciesMapper.currenciesDtoListMapping(returnList)
    }
}