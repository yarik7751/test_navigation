package by.yarik.test_navigation.activity.weather

import by.yarik.test_navigation.activity.base.BaseNavigation

interface WeatherNavigation: BaseNavigation {

    fun cityNext()

    fun cityBack()

    fun weatherParamsNext()

    fun weatherParamsBack()
}