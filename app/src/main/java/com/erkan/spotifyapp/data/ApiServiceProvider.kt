package com.erkan.spotifyapp.data

import com.erkan.spotifyapp.BuildConfig
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiServiceProvider {

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(BuildConfig.SERVER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    val apiServiceProvider = getRetrofit().create(ApiService::class.java)

}