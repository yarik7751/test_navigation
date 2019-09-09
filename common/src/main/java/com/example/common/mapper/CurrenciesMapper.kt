package com.example.common.mapper

import com.example.data_api.dto.CurrenciesDto
import com.example.domain.model.CurrencyModel

object CurrenciesMapper {

    fun currenciesDtoListMapping(dtoList: List<CurrenciesDto>): List<CurrencyModel> {
        return dtoList.map { dtoToModel(it) }
    }

    private fun dtoToModel(currenciesDto: CurrenciesDto): CurrencyModel {
        return CurrencyModel(
            title = currenciesDto.curNameEng,
            purchase = "2.444444",
            sale = "2.444444",
            titleType = false
        )
    }

    private fun modelToPreentationModel(model: CurrencyModel): Currency
}