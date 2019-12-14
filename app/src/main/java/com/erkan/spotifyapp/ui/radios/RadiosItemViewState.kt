package com.erkan.spotifyapp.ui.radios

import com.erkan.spotifyapp.ui.radios.model.Radio

data class RadiosItemViewState(val radio: Radio){

    fun getRadioName(): String {
        return radio.radioName ?: ""
    }

    fun getRadioBand(): String {
        return radio.band ?: ""
    }

    fun getRadioImageUrl(): String {
        return radio.logo_small ?: ""
    }
}