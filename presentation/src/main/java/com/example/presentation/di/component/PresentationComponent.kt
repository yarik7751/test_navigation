package com.example.presentation.di.component

import com.example.common.ActivityScope
import com.example.common.AppProvider
import com.example.presentation.activity.main.MainActivity
import com.example.presentation.activity.weather.WeatherActivity
import com.example.presentation.di.module.PresentationModule
import com.example.presentation.fragments.main.currencies.viewmodel.CurrenciesViewModel
import dagger.Component

@Component(dependencies = [AppProvider::class], modules = [PresentationModule::class])
@ActivityScope
abstract class PresentationComponent {

    abstract fun inject(activity: WeatherActivity)
    abstract fun inject(activity: MainActivity)
    abstract fun inject(viewModel: CurrenciesViewModel)

    companion object {

        var presentationComponent: PresentationComponent? = null

        fun init(appProvider: AppProvider): PresentationComponent? {
            presentationComponent = DaggerPresentationComponent.builder().appProvider(appProvider).build()
            return presentationComponent
        }

        fun get(): PresentationComponent? = presentationComponent
    }
}