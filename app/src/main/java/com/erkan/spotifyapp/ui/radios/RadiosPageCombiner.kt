package com.erkan.spotifyapp.ui.radios

import com.erkan.spotifyapp.data.Resource
import com.erkan.spotifyapp.ui.radios.model.Radio
import io.reactivex.functions.BiFunction

class RadiosPageCombiner : BiFunction<Resource<List<Radio>>, Resource<List<Radio>>, RadiosFragmentViewState> {
    override fun apply(t1: Resource<List<Radio>>, t2: Resource<List<Radio>>): RadiosFragmentViewState {
        return RadiosFragmentViewState(t1, t2)
    }
}