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
                navController?.navigate(R.id.cityFragment)
            }

            is Command.OpenWeatherParamsCommand -> {
                navController?.navigate(R.id.weatherParamsFragment)
            }

            is Command.OpenMapCommand -> {
                navController?.navigate(R.id.mapFragment)
            }
        }
    }

    override fun backTo(command: Command) {
        when (command) {
            is Command.OpenCityCommand -> {
                navController?.popBackStack(R.id.cityFragment, true)
            }

            is Command.OpenWeatherParamsCommand -> {
                navController?.popBackStack(R.id.weatherParamsFragment, true)
            }

            is Command.OpenMapCommand -> {
                navController?.popBackStack(R.id.mapFragment, true)
            }
        }
    }

    override fun back() {
        navController?.popBackStack()
    }

    override fun navigateTo(command: Command, args: Bundle) {
        when (command) {
            is Command.OpenCityCommand -> {
                navController?.navigate(R.id.cityFragment, args)
            }

            is Command.OpenWeatherParamsCommand -> {
                navController?.navigate(R.id.weatherParamsFragment, args)
            }

            is Command.OpenMapCommand -> {
                navController?.navigate(R.id.mapFragment, args)
            }
        }
    }
}