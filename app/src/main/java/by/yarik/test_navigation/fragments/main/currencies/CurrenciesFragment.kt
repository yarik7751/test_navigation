package by.yarik.test_navigation.fragments.main.currencies

import android.os.Bundle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import by.yarik.test_navigation.R
import by.yarik.test_navigation.activity.main.MainNavigation
import by.yarik.test_navigation.fragments.base.BaseFragment
import by.yarik.test_navigation.fragments.main.currencies.adapter.CurrenciesAdapter
import by.yarik.test_navigation.fragments.main.currencies.model.CurrencyModel
import by.yarik.test_navigation.fragments.main.currencies.viewmodel.CurrenciesViewModel
import kotlinx.android.synthetic.main.fragment_currencies.*

class CurrenciesFragment : BaseFragment<MainNavigation>(R.layout.fragment_currencies),
    LifecycleOwner {

    override fun titleRes(): Int = R.string.currencies_title

    override fun initViews(savedInstanceState: Bundle?) {

        val viewModel = ViewModelProviders.of(this).get(CurrenciesViewModel::class.java)
        viewModel.currenciesLiveData.observe(this, updateCurrencies())
        viewModel.updateCurrencies()

        rvCurrencies.layoutManager = LinearLayoutManager(context)
    }

    private fun updateCurrencies() = Observer<List<CurrencyModel>> {
        val currenciesList = mutableListOf(
            CurrencyModel(
                resources.getString(R.string.currencies_title),
                resources.getString(R.string.purchase_title),
                resources.getString(R.string.sale_title),
                true
            )
        )
        currenciesList.addAll(it)
        rvCurrencies.adapter = CurrenciesAdapter(currenciesList)
    }
}