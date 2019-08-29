package by.yarik.test_navigation.fragments.weather

import android.os.Bundle
import by.yarik.test_navigation.R
import by.yarik.test_navigation.activity.weather.WeatherNavigation
import by.yarik.test_navigation.fragments.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_city.*

class CityFragment: BaseFragment<WeatherNavigation>() {

    override fun layoutRes(): Int = R.layout.fragment_city

    override fun initViews(savedInstanceState: Bundle?) {

        btnNext.setOnClickListener {
            getNavigation()?.cityNext()
        }

        btnBack.setOnClickListener {
            getNavigation()?.cityBack()
        }
    }
}