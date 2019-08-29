package by.yarik.test_navigation.fragments.weather

import android.os.Bundle
import by.yarik.test_navigation.R
import by.yarik.test_navigation.activity.weather.WeatherNavigation
import by.yarik.test_navigation.fragments.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_weather_params.*

class WeatherParamsFragment: BaseFragment<WeatherNavigation>() {

    override fun layoutRes(): Int = R.layout.fragment_weather_params

    override fun initViews(savedInstanceState: Bundle?) {

        btnNext.setOnClickListener {
            getNavigation()?.weatherParamsNext()
        }

        btnBack.setOnClickListener {
            getNavigation()?.weatherParamsBack()
        }
    }
}