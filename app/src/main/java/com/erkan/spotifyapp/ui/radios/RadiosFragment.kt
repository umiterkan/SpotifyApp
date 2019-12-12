package com.erkan.spotifyapp.ui.radios

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.transition.Visibility
import com.erkan.spotifyapp.R
import com.erkan.spotifyapp.data.RadioDataSource
import com.erkan.spotifyapp.data.Status
import com.erkan.spotifyapp.databinding.FragmentRadiosBinding
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RadiosFragment : Fragment() {


    private lateinit var binding: FragmentRadiosBinding
    private val adapterLocation = RadiosAdapter()
    private val adapterPopular = RadiosAdapter()

    val radioDataSource = RadioDataSource()

    companion object {
        fun newInstance() = RadiosFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_radios, container, false)
        binding.recyclerLocation.adapter = adapterLocation
        binding.recyclerPopular.adapter = adapterPopular
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
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
                when (it.popularRadios.status) {
                    Status.LOADING -> {
                        binding.progressBarPopular.visibility = View.VISIBLE
                    }
                    Status.SUCCESS -> {
                        binding.progressBarPopular.visibility = View.GONE
                        adapterPopular.setList(it.popularRadios.data!!)
                    }
                }
                when (it.locationRadios.status) {
                    Status.LOADING -> {
                        binding.progressBarLocation.visibility = View.VISIBLE
                    }
                    Status.SUCCESS -> {
                        binding.progressBarLocation.visibility = View.GONE
                        adapterLocation.setList(it.locationRadios.data!!)
                    }
                }
            }

    }


}