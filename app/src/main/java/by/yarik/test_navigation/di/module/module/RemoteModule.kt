package by.yarik.test_navigation.di.module.module

import com.example.common.network.RestApi
import com.example.remote.RemoteDataSourceFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteModule {

    @Provides
    @Singleton
    fun provideRemoteDataStore(): RestApi = RemoteDataSourceFactory.makeApiService(true)
}