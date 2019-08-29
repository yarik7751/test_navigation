package by.yarik.test_navigation.activity.main

import by.yarik.test_navigation.activity.base.BaseNavigation

interface MainNavigation: BaseNavigation {

    fun userInfoNext()

    fun userInfoBack()

    fun settingsNext()

    fun settingsBack()

    fun currenciesNext()

    fun currenciesBack()
}