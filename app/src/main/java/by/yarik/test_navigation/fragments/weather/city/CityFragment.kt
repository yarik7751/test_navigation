package by.yarik.test_navigation.fragments.weather.city

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import by.yarik.test_navigation.R
import by.yarik.test_navigation.activity.weather.WeatherNavigation
import by.yarik.test_navigation.fragments.base.BaseFragment
import by.yarik.test_navigation.fragments.weather.city.adapter.CityAdapter
import by.yarik.test_navigation.fragments.weather.city.model.CityModel
import kotlinx.android.synthetic.main.fragment_city.*

class CityFragment: BaseFragment<WeatherNavigation>(R.layout.fragment_city) {

    private val cityModels = listOf(
        CityModel(1, "Minsk"),
        CityModel(2, "Baranovichi"),
        CityModel(3, "Pinsk"),
        CityModel(4, "Lahovichi"),
        CityModel(5, "Polotsk"),
        CityModel(6, "Brest"),
        CityModel(7, "Grodno")
    )

    override fun titleRes(): Int = R.string.city_title

    override fun initViews(savedInstanceState: Bundle?) {

        initCities()

        btnBack.setOnClickListener {
            getNavigation()?.cityBack()
        }
    }

    private fun initCities() {
        rvCities.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = CityAdapter(cityModels) {
                getNavigation()?.cityNext(it)
            }
        }
    }
}