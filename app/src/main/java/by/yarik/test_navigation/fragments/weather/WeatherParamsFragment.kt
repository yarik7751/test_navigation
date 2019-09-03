package by.yarik.test_navigation.fragments.weather

import android.os.Bundle
import by.yarik.test_navigation.R
import by.yarik.test_navigation.activity.weather.WeatherNavigation
import by.yarik.test_navigation.fragments.base.BaseFragment
import by.yarik.test_navigation.fragments.weather.city.model.CityModel
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