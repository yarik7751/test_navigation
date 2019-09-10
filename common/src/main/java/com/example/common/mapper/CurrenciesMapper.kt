package com.example.common.mapper

import com.example.data_api.dto.CurrenciesDto
import com.example.domain.model.CurrencyModel
import com.example.presentation_api.CurrencyPresentationModel

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

    fun currenciesModelsMapping(models: List<CurrencyModel>): List<CurrencyPresentationModel> =
        models.map { modelToPresentationModel(it) }


    private fun modelToPresentationModel(model: CurrencyModel): CurrencyPresentationModel =
        CurrencyPresentationModel(
            title = model.title,
            titleType = model.titleType,
            sale = model.sale,
            purchase = model.purchase
        )

}