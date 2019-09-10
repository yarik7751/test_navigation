package com.example.presentation.fragments.main.currencies.viewmodel

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.mapper.CurrenciesMapper
import com.example.domain.CurrenciesInteractor
import com.example.presentation.di.component.PresentationComponent
import com.example.presentation_api.CurrencyPresentationModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CurrenciesViewModel: ViewModel(), LifecycleObserver {

    @Inject
    lateinit var currenciesInteractor: CurrenciesInteractor

    init {
        PresentationComponent.get()?.inject(this)
    }

    val currenciesLiveData: MutableLiveData<List<CurrencyPresentationModel>> by lazy {
        MutableLiveData<List<CurrencyPresentationModel>>()
    }

    fun updateCurrencies() {
        viewModelScope.launch {
            val result = get()
            currenciesLiveData.value = result
        }
    }

    suspend fun get() = withContext(Dispatchers.IO) {
        try {
            val result = CurrenciesMapper.currenciesModelsMapping(currenciesInteractor.getCurrenciesAsync())
            result
        } catch (exception: Exception) {
            emptyList<CurrencyPresentationModel>()
        }
    }
}