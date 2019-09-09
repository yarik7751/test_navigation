package com.example.common.network

import com.example.data_api.dto.CurrenciesDto
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface RestApi {

    @GET("ExRates/Currencies")
    fun getCurrenciesAsync(): Deferred<Response<List<CurrenciesDto>>>
}