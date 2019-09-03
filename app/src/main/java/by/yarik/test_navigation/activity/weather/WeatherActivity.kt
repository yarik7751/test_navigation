package by.yarik.test_navigation.activity.weather

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import by.yarik.test_navigation.R
import by.yarik.test_navigation.activity.base.BaseActivity
import by.yarik.test_navigation.fragments.weather.WeatherParamsFragment
import by.yarik.test_navigation.fragments.weather.city.model.CityModel

class WeatherActivity: BaseActivity(), WeatherNavigation {

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        navController = Navigation.findNavController(this, R.id.navHostFragment)
    }

    override fun cityNext(model: CityModel) {
        val args = getCityModelArgs(model)
        navController.navigate(R.id.action_cityFragment_to_weatherParamsFragment, args)
    }

    override fun cityBack() {
        finish()
    }

    override fun weatherParamsOpenMap(model: CityModel) {
        val args = getCityModelArgs(model)
        navController.navigate(R.id.action_weatherParamsFragment_to_mapFragment, args)
    }

    override fun weatherParamsBack() {
        navController.popBackStack()
    }

    private fun getCityModelArgs(model: CityModel): Bundle {
        val args = Bundle()
        args.putParcelable(WeatherParamsFragment.ARGS_CITY, model)
        return args
    }

    override fun mapBackToCity() {
        navController.popBackStack(R.id.cityFragment, true)
    }
}