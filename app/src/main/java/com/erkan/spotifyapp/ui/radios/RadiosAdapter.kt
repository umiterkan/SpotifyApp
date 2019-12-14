package com.erkan.spotifyapp.ui.radios

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.erkan.spotifyapp.R
import com.erkan.spotifyapp.databinding.ItemRadioBinding
import com.erkan.spotifyapp.ui.radios.model.Radio
import com.squareup.picasso.Picasso

class RadiosAdapter : RecyclerView.Adapter<RadiosAdapter.RadiosItemViewHolder>() {

    private var radioList = arrayListOf<Radio>()

    fun setList(radioList: List<Radio>) {
        this.radioList.clear()
        this.radioList.addAll(radioList)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RadiosItemViewHolder =
        RadiosItemViewHolder.createRadioItemView(parent)

    override fun getItemCount(): Int = radioList.size

    override fun onBindViewHolder(holder: RadiosItemViewHolder, position: Int) {
        holder.bind(radioList.get(position))
    }


    class RadiosItemViewHolder(val binding: ItemRadioBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Radio) {
            binding.viewState=RadiosItemViewState(item)

        }

        companion object {
            fun createRadioItemView(parent: ViewGroup): RadiosItemViewHolder {

                val binding = DataBindingUtil.inflate<ItemRadioBinding>(
                    LayoutInflater.from(parent.context),
                    R.layout.item_radio,
                    parent,
                    false
                )
                return RadiosItemViewHolder(binding)

            }
        }
    }

}