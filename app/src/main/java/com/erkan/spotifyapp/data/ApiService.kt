package com.erkan.spotifyapp.data

import com.erkan.spotifyapp.ui.radios.model.Radio
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

    @GET("popularRadios.json")
    fun popularRadios(): Single<List<Radio>>

    @GET("locationRadios.json")
    fun locationRadios(): Single<List<Radio>>

}