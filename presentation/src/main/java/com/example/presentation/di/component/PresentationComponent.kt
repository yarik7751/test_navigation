package com.example.presentation.di.component

import com.example.common.ActivityScope
import com.example.common.NavigationProvider
import com.example.presentation.activity.weather.WeatherActivity
import com.example.presentation.di.module.PresentationModule
import dagger.Component

@Component(dependencies = [NavigationProvider::class], modules = [PresentationModule::class])
@ActivityScope
abstract class PresentationComponent {

    abstract fun inject(activity: WeatherActivity)

    companion object {

        fun init(navigationProvider: NavigationProvider): PresentationComponent =
            DaggerPresentationComponent.builder().navigationProvider(navigationProvider).build()
    }
}