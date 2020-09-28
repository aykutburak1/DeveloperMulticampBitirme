package com.aykutpullu.multicampandroidassignment.model

import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.aykutpullu.multicampandroidassignment.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun ImageView.downloadImage(url : String) {
    val options = RequestOptions()
        .error(R.drawable.ic_launcher_background)

    Glide.with(context)
        .setDefaultRequestOptions(options)
        .load(url)
        .into(this)

}

fun ImageView.downloadImageCircular(url : String) {
    Glide.with(context).load(url).apply(RequestOptions.circleCropTransform()).into(this);


}