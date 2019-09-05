package com.example.presentation.fragments.main

import android.os.Bundle
import com.example.presentation.R
import com.example.presentation.activity.main.MainNavigation
import com.example.presentation.fragments.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_settings.*

class SettingsFragment: BaseFragment<MainNavigation>(R.layout.fragment_settings) {

    override fun titleRes(): Int = R.string.settings_title

    override fun initViews(savedInstanceState: Bundle?) {

        btnOpenWeather.setOnClickListener {
            getNavigation()?.openWeatherScreen()
        }
    }
}