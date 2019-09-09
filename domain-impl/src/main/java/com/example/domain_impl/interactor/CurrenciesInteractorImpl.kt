package com.example.domain_impl.interactor

import com.example.domain.CurrenciesInteractor
import com.example.domain.model.CurrencyModel
import com.example.domain.repository.CurrenciesRepository
import javax.inject.Inject

class CurrenciesInteractorImpl @Inject constructor(
    val currenciesRepository: CurrenciesRepository
): CurrenciesInteractor {

    override suspend fun getCurrenciesAsync(): List<CurrencyModel> =
        currenciesRepository.getCurrenciesAsync().subList(0, 4)
}