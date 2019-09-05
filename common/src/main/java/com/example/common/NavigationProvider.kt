package com.example.common

import com.example.navigation_api.NavigationCommands
import com.example.navigation_api.NavigationInit

interface NavigationProvider {

    fun navigationInit(): NavigationInit

    fun navigationCommands(): NavigationCommands
}