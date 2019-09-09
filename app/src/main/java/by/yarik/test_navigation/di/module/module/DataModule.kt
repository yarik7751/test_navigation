package by.yarik.test_navigation.di.module.module

import com.example.common.network.RestApi
import com.example.data_impl.CurrenciesRepositoryImpl
import com.example.domain.repository.CurrenciesRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    fun provideCurrenciesRepository(restApi: RestApi): CurrenciesRepository = CurrenciesRepositoryImpl(restApi)
}