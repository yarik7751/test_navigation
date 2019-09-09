package by.yarik.test_navigation

import android.app.Application
import by.yarik.test_navigation.di.module.component.AppComponent
import com.example.common.AppProvider
import com.example.common.BaseApp

class BaseApplication: Application(), BaseApp {

    private val appComponent: AppComponent by lazy {
        AppComponent.init()
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun getAppProvider(): AppProvider = appComponent
}