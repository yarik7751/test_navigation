package com.example.common.network

import retrofit2.http.GET

interface RestApi {

    @GET("test")
    suspend fun test()
}