package com.example.remote

import com.example.common.network.RestApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RemoteDataSourceFactory {

    private const val BASE_URL = "https://testapi.com"

    fun makeApiService(debug: Boolean): RestApi {
        val logging = HttpLoggingInterceptor()

        if(debug) {
            logging.level = HttpLoggingInterceptor.Level.BODY
        } else {
            logging.level = HttpLoggingInterceptor.Level.NONE
        }

        val onHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(onHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(RestApi::class.java)
    }
}