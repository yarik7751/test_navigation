package com.example.presentation.activity.weather

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.common.BaseApp
import com.example.navigation_api.Command
import com.example.navigation_api.NavigationCommands
import com.example.navigation_api.NavigationInit
import com.example.presentation.R
import com.example.presentation.activity.base.BaseActivity
import com.example.presentation.di.component.PresentationComponent
import com.example.presentation.fragments.weather.MapFragment
import com.example.presentation.fragments.weather.WeatherParamsFragment
import com.example.presentation.fragments.weather.city.model.CityModel
import javax.inject.Inject

class WeatherActivity: BaseActivity(),
    WeatherNavigation {

    @Inject
    lateinit var navigationInt: NavigationInit

    @Inject
    lateinit var navigationCommands: NavigationCommands

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        PresentationComponent
            .init((applicationContext as BaseApp).getNavigationProvider())
            .inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        navController = Navigation.findNavController(this, R.id.navHostFragment)
    }

    override fun cityNext(model: CityModel) {
        val args = Bundle()
        args.putParcelable(WeatherParamsFragment.ARGS_CITY, model)
        navigationCommands.navigateTo(Command.OpenWeatherParamsCommand, args)
    }

    override fun cityBack() {
        navigationCommands.back()
    }

    override fun weatherParamsOpenMap(model: CityModel) {
        val args = Bundle()
        args.putParcelable(MapFragment.ARGS_CITY, model)
        navigationCommands.navigateTo(Command.OpenMapCommand, args)
    }

    override fun weatherParamsBack() {
        navigationCommands.back()
    }

    override fun mapBackToCity() {
        navigationCommands.backTo(Command.OpenCityCommand)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigationInt.add(navController)
    }

    override fun onPause() {
        navigationInt.remove()
        super.onPause()
    }
}