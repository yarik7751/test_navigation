package by.yarik.test_navigation.fragments.main.currencies

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import by.yarik.test_navigation.R
import by.yarik.test_navigation.activity.main.MainNavigation
import by.yarik.test_navigation.fragments.base.BaseFragment
import by.yarik.test_navigation.fragments.main.currencies.adapter.CurrenciesAdapter
import by.yarik.test_navigation.fragments.main.currencies.model.CurrencyModel
import kotlinx.android.synthetic.main.fragment_currencies.*

class CurrenciesFragment: BaseFragment<MainNavigation>(R.layout.fragment_currencies) {

    private lateinit var currencies: List<CurrencyModel>

    override fun titleRes(): Int = R.string.currencies_title

    override fun initViews(savedInstanceState: Bundle?) {
        currencies = listOf(
            CurrencyModel(
                resources.getString(R.string.currencies_title),
                resources.getString(R.string.purchase_title),
                resources.getString(R.string.sale_title),
                true),
            CurrencyModel("USD", "2.1080", "2.1150"),
            CurrencyModel("EUR", "2.3120", "2.3200"),
            CurrencyModel("100 RUB", "3.1350", "2.1950")
        )

        rvCurrencies.layoutManager = LinearLayoutManager(context)
        rvCurrencies.adapter = CurrenciesAdapter(currencies)
    }
}