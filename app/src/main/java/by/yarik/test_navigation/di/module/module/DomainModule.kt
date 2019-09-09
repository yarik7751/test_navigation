package by.yarik.test_navigation.di.module.module

import com.example.domain.CurrenciesInteractor
import com.example.domain.repository.CurrenciesRepository
import com.example.domain_impl.interactor.CurrenciesInteractorImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DomainModule {

    @Provides
    @Singleton
    fun provideCurrenciesInteractor(currenciesRepository: CurrenciesRepository): CurrenciesInteractor =
        CurrenciesInteractorImpl(currenciesRepository)
}