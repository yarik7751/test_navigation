package com.example.presentation.activity.weather

import com.example.presentation.activity.base.BaseNavigation
import com.example.presentation.fragments.weather.city.model.CityModel

interface WeatherNavigation: BaseNavigation {

    fun cityNext(model: CityModel)

    fun cityBack()

    fun weatherParamsOpenMap(model: CityModel)

    fun weatherParamsBack()

    fun mapBackToCity()
}