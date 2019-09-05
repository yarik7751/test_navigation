package by.yarik.test_navigation.di.module.component

import by.yarik.test_navigation.BaseApplication
import by.yarik.test_navigation.di.module.module.NavigationModule
import com.example.common.NavigationProvider
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NavigationModule::class])
@Singleton
abstract class NavigationComponent: NavigationProvider {

    abstract fun inject(application: BaseApplication)
}