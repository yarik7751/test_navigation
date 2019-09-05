package com.example.navigation_api

sealed class Command{
    object OpenCityCommand: Command()

    object OpenWeatherParamsCommand: Command()
}

