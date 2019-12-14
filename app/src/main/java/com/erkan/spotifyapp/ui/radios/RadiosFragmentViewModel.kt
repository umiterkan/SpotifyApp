package com.erkan.spotifyapp.ui.radios

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.erkan.spotifyapp.data.RadioDataSource
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RadiosFragmentViewModel : ViewModel() {

    val radioDataSource = RadioDataSource()

    val liveData: MutableLiveData<RadiosFragmentViewState> =
        MutableLiveData()

    init {
        loadData()
    }


    @SuppressLint("CheckResult")
    private fun loadData() {

        var popularRadios = radioDataSource.popularRadios()
        var locationRadios = radioDataSource.locationRadios()

        Observable.combineLatest(popularRadios, locationRadios, RadiosPageCombiner())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                liveData.postValue(it)
            }

    }

}