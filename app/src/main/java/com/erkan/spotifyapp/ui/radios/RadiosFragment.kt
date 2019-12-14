package com.erkan.spotifyapp.ui.radios

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.erkan.spotifyapp.R
import com.erkan.spotifyapp.databinding.FragmentRadiosBinding

class RadiosFragment : Fragment() {


    private lateinit var binding: FragmentRadiosBinding
    private val adapterLocation = RadiosAdapter()
    private val adapterPopular = RadiosAdapter()

    private lateinit var viewModel: RadiosFragmentViewModel

    companion object {
        fun newInstance() = RadiosFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RadiosFragmentViewModel::class.java)
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
        viewModel.liveData.observe(this, Observer {
            adapterLocation.setList(it.getLocationRadios())
            adapterPopular.setList(it.getPopularRadios())
            binding.viewState = it
            binding.executePendingBindings()
        })
    }


}