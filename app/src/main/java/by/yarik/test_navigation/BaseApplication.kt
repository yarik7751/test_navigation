package by.yarik.test_navigation

import android.app.Application
import by.yarik.test_navigation.di.module.component.DaggerNavigationComponent
import by.yarik.test_navigation.di.module.component.NavigationComponent
import com.example.common.BaseApp
import com.example.common.NavigationProvider

class BaseApplication: Application(), BaseApp {

    private val navigationComponent: NavigationComponent by lazy {
        DaggerNavigationComponent.builder().build()
    }

    override fun onCreate() {
        super.onCreate()
        navigationComponent.inject(this)
    }

    override fun getNavigationProvider(): NavigationProvider = navigationComponent
}