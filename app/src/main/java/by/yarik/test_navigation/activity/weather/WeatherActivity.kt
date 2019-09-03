package by.yarik.test_navigation.activity.weather

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import by.yarik.test_navigation.R
import by.yarik.test_navigation.activity.base.BaseActivity
import by.yarik.test_navigation.fragments.weather.MapFragment
import by.yarik.test_navigation.fragments.weather.city.model.CityModel

class WeatherActivity: BaseActivity(), WeatherNavigation {

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        navController = Navigation.findNavController(this, R.id.navHostFragment)
    }

    override fun cityNext(direction: NavDirections) {
        navController.navigate(direction)
    }

    override fun cityBack() {
        finish()
    }

    override fun weatherParamsOpenMap(model: CityModel) {
        val args = Bundle()
        args.putParcelable(MapFragment.ARGS_CITY, model)
        navController.navigate(R.id.action_weatherParamsFragment_to_mapFragment, args)
    }

    override fun weatherParamsBack() {
        navController.popBackStack()
    }

    override fun mapBackToCity() {
        navController.popBackStack(R.id.cityFragment, true)
    }
}