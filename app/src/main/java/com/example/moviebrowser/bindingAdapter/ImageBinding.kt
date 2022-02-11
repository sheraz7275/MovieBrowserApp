package com.example.moviebrowser.bindingAdapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import javax.inject.Singleton

@Singleton
object ImageBinding {
    private const val BASE_PATH = "https://image.tmdb.org/t/p/w500"

    @JvmStatic
    @BindingAdapter("loadImage")
    fun bindImage(movieImage: ImageView, moviePath: String) {
        Glide.with(movieImage.context)
            .load(BASE_PATH + moviePath)
            .into(movieImage)
    }
}