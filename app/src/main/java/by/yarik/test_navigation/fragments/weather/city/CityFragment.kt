package by.yarik.test_navigation.fragments.weather.city

import android.os.Bundle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import by.yarik.test_navigation.R
import by.yarik.test_navigation.activity.weather.WeatherNavigation
import by.yarik.test_navigation.fragments.base.BaseFragment
import by.yarik.test_navigation.fragments.weather.city.adapter.CityAdapter
import by.yarik.test_navigation.fragments.weather.city.model.CityModel
import by.yarik.test_navigation.fragments.weather.city.viewmodel.CityViewModel
import kotlinx.android.synthetic.main.fragment_city.*

class CityFragment: BaseFragment<WeatherNavigation>(R.layout.fragment_city), LifecycleOwner {

    override fun titleRes(): Int = R.string.city_title

    override fun initViews(savedInstanceState: Bundle?) {

        val viewModel = ViewModelProviders.of(this).get(CityViewModel::class.java)
        viewModel.citiesLiveData.observe(this, updateCities())

        lifecycle.addObserver(viewModel)

        rvCities.layoutManager = LinearLayoutManager(context)
        btnBack.setOnClickListener {
            getNavigation()?.cityBack()
        }

        viewModel.getCities()
    }

    private fun updateCities(): Observer<List<CityModel>> = Observer {
            rvCities.adapter = CityAdapter(it) {
                val args = CityFragmentDirections.actionCityFragmentToWeatherParamsFragment(it)
                getNavigation()?.cityNext(args)
            }
        }
}