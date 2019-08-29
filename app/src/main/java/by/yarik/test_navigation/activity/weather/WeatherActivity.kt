package by.yarik.test_navigation.activity.weather

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import by.yarik.test_navigation.R

class WeatherActivity: AppCompatActivity(), WeatherNavigation {

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        navController = Navigation.findNavController(this, R.id.navHostFragment)
    }

    override fun cityNext() {
        navController.navigate(R.id.weatherParamsFragment)
    }

    override fun cityBack() {
        finish()
    }

    override fun weatherParamsNext() {
    }

    override fun weatherParamsBack() {
        navController.popBackStack()
    }
}