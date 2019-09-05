package com.example.presentation.fragments.weather.city

import android.os.Bundle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.presentation.R
import com.example.presentation.activity.weather.WeatherNavigation
import com.example.presentation.fragments.base.BaseFragment
import com.example.presentation.fragments.weather.city.adapter.CityAdapter
import com.example.presentation.fragments.weather.city.model.CityModel
import com.example.presentation.fragments.weather.city.viewmodel.CityViewModel
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

    private fun updateCities() = Observer<List<CityModel>> {
            rvCities.adapter =
                CityAdapter(it) {
                    getNavigation()?.cityNext(it)
                }
        }
}