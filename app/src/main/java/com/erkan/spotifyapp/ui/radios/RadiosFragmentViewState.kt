package com.erkan.spotifyapp.ui.radios

import android.view.View
import com.erkan.spotifyapp.data.Resource
import com.erkan.spotifyapp.data.Status
import com.erkan.spotifyapp.ui.radios.model.Radio

data class RadiosFragmentViewState(
    val popularRadios: Resource<List<Radio>>,
    val locationRadios: Resource<List<Radio>>
){

    fun getPopularRadios() = popularRadios.data ?: arrayListOf()

    fun getLocationRadios() = locationRadios.data ?: arrayListOf()

    fun getPopularRadiosLoadingVisibility(): Int {
        return when (popularRadios.status) {
            Status.LOADING -> View.VISIBLE
            else -> View.GONE
        }
    }

    fun getLocationRadiosLoadingVisibility(): Int {
        return when (locationRadios.status) {
            Status.LOADING -> View.VISIBLE
            else -> View.GONE
        }
    }



}