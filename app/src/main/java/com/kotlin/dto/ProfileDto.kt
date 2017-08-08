package com.kotlin.dto

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.squareup.picasso.Picasso

/**
 * Created by arun on 8/8/17.
 */
@BindingAdapter("url")
fun loadImage(view: ImageView, url : String) {
    Picasso.with(view.context).load(url).placeholder(android.R.drawable.btn_default).into(view)
}

data class ProfileDto(val url : String, val name : String)