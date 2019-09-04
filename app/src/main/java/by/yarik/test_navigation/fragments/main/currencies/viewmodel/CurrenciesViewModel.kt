package by.yarik.test_navigation.fragments.main.currencies.viewmodel

import android.util.Log
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.yarik.test_navigation.fragments.main.currencies.model.CurrencyModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CurrenciesViewModel: ViewModel(), LifecycleObserver {

    val currenciesLiveData: MutableLiveData<List<CurrencyModel>> by lazy {
        MutableLiveData<List<CurrencyModel>>()
    }

    fun updateCurrencies() {
        viewModelScope.launch {
            val result = get()
            currenciesLiveData.value = result
        }
    }

    suspend fun get() = withContext(Dispatchers.IO) {
        try {
            delay(1000)
            val list = listOf(
                CurrencyModel("USD", "2.1080", "2.1150"),
                CurrencyModel("EUR", "2.3120", "2.3200"),
                CurrencyModel("100 RUB", "3.1350", "2.1950")
            )

            if (list.size > 5) throw Exception("example")

            list
        } catch (exception: Exception) {
            Log.d("", "")
            emptyList<CurrencyModel>()
        }
    }
}