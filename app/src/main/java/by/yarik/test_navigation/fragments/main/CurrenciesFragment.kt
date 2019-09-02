package by.yarik.test_navigation.fragments.main

import android.os.Bundle
import by.yarik.test_navigation.R
import by.yarik.test_navigation.activity.main.MainNavigation
import by.yarik.test_navigation.fragments.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_currencies.*

class CurrenciesFragment: BaseFragment<MainNavigation>() {

    override fun layoutRes(): Int = R.layout.fragment_currencies

    override fun initViews(savedInstanceState: Bundle?) {

        btnNext.setOnClickListener {
            getNavigation()?.currenciesNext()
        }

        btnBack.setOnClickListener {
            getNavigation()?.currenciesBack()
        }

        btnHome.setOnClickListener {
            getNavigation()?.currenciesHome()
        }
    }
}