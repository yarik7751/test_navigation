package com.example.navigation_api

import androidx.navigation.NavController

interface NavigationInit {

    fun add(navController: NavController)

    fun remove()
}