package by.yarik.test_navigation.fragments.weather.city.viewmodel

import androidx.lifecycle.*
import by.yarik.test_navigation.fragments.weather.city.model.CityModel
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class CityViewModel: ViewModel(), LifecycleObserver {

    val compositeDisposable = CompositeDisposable()

    val citiesLiveData: MutableLiveData<List<CityModel>> by lazy {
        MutableLiveData<List<CityModel>>()
    }

    fun getCities() {
        addDisposable(Observable.fromCallable {
            return@fromCallable listOf(
                CityModel(1, "Minsk"),
                CityModel(2, "Baranovichi"),
                CityModel(3, "Pinsk"),
                CityModel(4, "Lahovichi"),
                CityModel(5, "Polotsk"),
                CityModel(6, "Brest"),
                CityModel(7, "Grodno")
            )
        }
            .subscribeOn(Schedulers.io())
            .subscribe({
                citiesLiveData.postValue(it)
            }, {}))
    }

    private fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private fun disposableClear() {
        compositeDisposable.clear()
    }
}