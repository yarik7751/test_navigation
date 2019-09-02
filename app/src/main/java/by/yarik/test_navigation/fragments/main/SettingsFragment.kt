package by.yarik.test_navigation.fragments.main

import android.os.Bundle
import by.yarik.test_navigation.R
import by.yarik.test_navigation.activity.main.MainNavigation
import by.yarik.test_navigation.fragments.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_settings.*

class SettingsFragment: BaseFragment<MainNavigation>() {

    override fun layoutRes(): Int = R.layout.fragment_settings

    override fun initViews(savedInstanceState: Bundle?) {

        btnNext.setOnClickListener {
            getNavigation()?.settingsNext()
        }

        btnBack.setOnClickListener {
            getNavigation()?.settingsBack()
        }

        btnHome.setOnClickListener {
            getNavigation()?.settingsHome()
        }
    }
}