package com.example.presentation.fragments.weather

import android.os.Bundle
import com.example.presentation.R
import com.example.presentation.activity.weather.WeatherNavigation
import com.example.presentation.fragments.base.BaseFragment
import com.example.presentation.fragments.weather.city.model.CityModel
import kotlinx.android.synthetic.main.fragment_weather_params.*

class WeatherParamsFragment: BaseFragment<WeatherNavigation>(R.layout.fragment_weather_params) {

    companion object {
        const val ARGS_CITY = "ARGS_CITY"
    }

    override fun titleRes(): Int = R.string.weather_params_title

    override fun initViews(savedInstanceState: Bundle?) {

        initTitle()

        btnOpenMap.setOnClickListener {
            val cityModel = getCityModel()
            if(cityModel.title.isNotEmpty()) {
                getNavigation()?.weatherParamsOpenMap(cityModel)
            }
        }

        btnBack.setOnClickListener {
            getNavigation()?.weatherParamsBack()
        }
    }

    private fun initTitle() {
        val title = getCityModel().title
        tvCityTitle.text = title
    }

    private fun getCityModel(): CityModel {
        return arguments?.let {
            val model = it.getParcelable<CityModel>(ARGS_CITY)
            model ?: CityModel()
        } ?: CityModel()
    }
}