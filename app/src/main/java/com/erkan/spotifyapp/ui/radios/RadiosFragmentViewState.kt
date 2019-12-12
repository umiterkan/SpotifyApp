package com.erkan.spotifyapp.ui.radios

import com.erkan.spotifyapp.data.Resource
import com.erkan.spotifyapp.ui.radios.model.Radio

data class RadiosFragmentViewState(
    val popularRadios: Resource<List<Radio>>,
    val locationRadios: Resource<List<Radio>>
)