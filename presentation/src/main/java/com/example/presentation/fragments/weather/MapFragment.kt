package com.example.presentation.fragments.weather

import android.location.Geocoder
import android.os.Bundle
import com.example.presentation.R
import com.example.presentation.activity.weather.WeatherNavigation
import com.example.presentation.fragments.base.BaseFragment
import com.example.presentation.fragments.weather.city.model.CityModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import kotlinx.android.synthetic.main.fragment_map.*

class MapFragment: BaseFragment<WeatherNavigation>(R.layout.fragment_map), OnMapReadyCallback {

    companion object {
        const val ARGS_CITY = "ARGS_CITY"
    }

    override fun titleRes(): Int = R.string.map

    override fun initViews(savedInstanceState: Bundle?) {

        btnBackToCity.setOnClickListener {
            getNavigation()?.mapBackToCity()
        }

        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(map: GoogleMap?) {
        val locationTitle = getCityModel().title
        val geocoder = Geocoder(context)
        val address = geocoder.getFromLocationName(locationTitle, 1).first()
        map?.let {
            val cameraUpdate = CameraUpdateFactory.newLatLngZoom(LatLng(address.latitude, address.longitude), 12f)
            it.moveCamera(cameraUpdate)
        }
    }

    private fun getCityModel(): CityModel {
        return arguments?.let {
            val model = it.getParcelable<CityModel>(
                ARGS_CITY
            )
            model ?: CityModel()
        } ?: CityModel()
    }
}