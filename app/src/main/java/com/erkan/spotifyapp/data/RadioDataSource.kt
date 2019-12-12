package com.erkan.spotifyapp.data

import com.erkan.spotifyapp.ui.radios.model.Radio
import io.reactivex.Observable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class RadioDataSource {
    val apiService = ApiServiceProvider()



    fun popularRadios(): Observable<Resource<List<Radio>>> {
        return Observable.create { emitter ->
            emitter.onNext(Resource.loading())
            apiService.apiServiceProvider
                .popularRadios()
                .subscribeOn(Schedulers.io())
                .subscribe({
                    emitter.onNext(Resource.success(it))
                    emitter.onComplete()
                }, {
                    emitter.onNext(Resource.error(it.message ?: ""))
                    emitter.onComplete()
                })
        }
    }

    fun locationRadios(): Observable<Resource<List<Radio>>> {

        return Observable.create { emitter ->
            emitter.onNext(Resource.loading())
            apiService.apiServiceProvider.locationRadios()
                .subscribeOn(Schedulers.io())
                .subscribe(Consumer {
                    emitter.onNext(Resource.success(it))
                    emitter.onComplete()
                }, Consumer {
                    emitter.onNext(Resource.error(it.message?:""))
                    emitter.onComplete()
                })
        }

    }

}