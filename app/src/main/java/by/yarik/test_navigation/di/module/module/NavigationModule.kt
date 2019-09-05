package by.yarik.test_navigation.di.module.module

import com.example.navigation_api.NavigationCommands
import com.example.navigation_api.NavigationInit
import com.example.navigation_impl.NavigationImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NavigationModule {

    @Provides
    @Singleton
    fun provideNavigationImpl() = NavigationImpl()

    @Provides
    fun provideNavigation(navigationImpl: NavigationImpl): NavigationCommands = navigationImpl

    @Provides
    fun provideNavigationInit(navigationImpl: NavigationImpl): NavigationInit = navigationImpl
}