package by.yarik.test_navigation.activity.weather

import by.yarik.test_navigation.activity.base.BaseNavigation
import by.yarik.test_navigation.fragments.weather.city.model.CityModel

interface WeatherNavigation: BaseNavigation {

    fun cityNext(model: CityModel)

    fun cityBack()

    fun weatherParamsNext()

    fun weatherParamsBack()
}