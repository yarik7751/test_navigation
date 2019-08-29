package by.yarik.test_navigation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import by.yarik.test_navigation.R
import by.yarik.test_navigation.fragments.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_currencies.*

class CurrenciesFragment: BaseFragment() {

    override fun layoutRes(): Int = R.layout.fragment_currencies

    override fun initViews(savedInstanceState: Bundle?) {

        btnNext.setOnClickListener {
            getMainNavigation()?.currenciesNext()
        }

        btnBack.setOnClickListener {
            getMainNavigation()?.currenciesBack()
        }
    }
}