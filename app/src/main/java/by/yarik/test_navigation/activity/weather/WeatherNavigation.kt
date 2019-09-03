package by.yarik.test_navigation.activity.weather

import androidx.navigation.NavDirections
import by.yarik.test_navigation.activity.base.BaseNavigation
import by.yarik.test_navigation.fragments.weather.city.model.CityModel

interface WeatherNavigation: BaseNavigation {

    fun cityNext(direction: NavDirections)

    fun cityBack()

    fun weatherParamsOpenMap(model: CityModel)

    fun weatherParamsBack()

    fun mapBackToCity()
}