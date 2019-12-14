package com.erkan.spotifyapp.ui.util.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("loadImage")
fun loadImage(imageView: ImageView, imageUrl: String) {
    if (!imageUrl.isEmpty()) {
        Picasso.get().load(imageUrl).into(imageView)
    }
}