package com.example.presentation.fragments.weather.city.viewmodel

import android.util.Log
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.presentation.fragments.weather.city.model.CityModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CityViewModel : ViewModel(), LifecycleObserver {

    val citiesLiveData: MutableLiveData<List<CityModel>> by lazy {
        MutableLiveData<List<CityModel>>()
    }

    fun getCities() {
        viewModelScope.launch {
            val result = get()
            citiesLiveData.value = result
        }
    }

    suspend fun get() = withContext(Dispatchers.IO) {
        try {
            delay(1000)
            val list = listOf(
                CityModel(1, "Minsk"),
                CityModel(2, "Baranovichi"),
                CityModel(3, "Pinsk"),
                CityModel(4, "Lahovichi"),
                CityModel(5, "Polotsk"),
                CityModel(6, "Brest"),
                CityModel(7, "Grodno")
            )

            if (list.size > 50) throw Exception("example")

            list
        } catch (exception: Exception) {
            Log.d("", "")
            emptyList<CityModel>()
        }
    }
}