package by.yarik.test_navigation.di.module.component

import by.yarik.test_navigation.di.module.module.DataModule
import by.yarik.test_navigation.di.module.module.DomainModule
import by.yarik.test_navigation.di.module.module.RemoteModule
import com.example.common.AppProvider
import com.example.common.NavigationProvider
import dagger.Component
import javax.inject.Singleton

@Component(dependencies = [NavigationProvider::class], modules = [RemoteModule::class, DataModule::class, DomainModule::class])
@Singleton
abstract class AppComponent: AppProvider {

    companion object {

        fun init(): AppComponent {
            val navigationComponent = DaggerNavigationComponent.builder().build()
            return DaggerAppComponent.builder().navigationProvider(navigationComponent).build()
        }
    }
}