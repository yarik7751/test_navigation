package com.example.navigation_impl

import android.os.Bundle
import androidx.navigation.NavController
import com.example.navigation_api.Command
import com.example.navigation_api.NavigationCommands
import com.example.navigation_api.NavigationInit
import javax.inject.Inject

class NavigationImpl @Inject constructor(): NavigationInit, NavigationCommands {

    var navController: NavController? = null

    override fun add(navController: NavController) {
        this.navController = navController
    }

    override fun remove() {
        navController = null
    }

    override fun navigateTo(command: Command) {
        when (command) {
            is Command.OpenCityCommand -> {

            }

            is Command.OpenWeatherParamsCommand -> {
                navController?.navigate(R.id.weatherParamsFragment)
            }
        }
    }

    override fun backTo(command: Command) {
        when (command) {
            is Command.OpenCityCommand -> {

            }

            is Command.OpenWeatherParamsCommand -> {

            }
        }
    }

    override fun navigateTo(command: Command, args: Bundle) {
        when (command) {
            is Command.OpenCityCommand -> {

            }

            is Command.OpenWeatherParamsCommand -> {
                navController?.navigate(R.id.weatherParamsFragment, args)
            }
        }
    }
}