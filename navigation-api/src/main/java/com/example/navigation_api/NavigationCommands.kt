package com.example.navigation_api

import android.os.Bundle

interface NavigationCommands {

    fun navigateTo(command: Command)

    fun navigateTo(command: Command, args: Bundle)

    fun backTo(command: Command)

    fun back()
}