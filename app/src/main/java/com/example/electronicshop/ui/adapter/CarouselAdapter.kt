package com.example.electronicshop.ui.adapter

import android.view.View
import android.widget.ImageView
import androidx.constraintlayout.helper.widget.Carousel
import coil.load

class CarouselAdapter(private val imagesUrl: List<String>?): Carousel.Adapter{

        override fun count(): Int {
            return imagesUrl?.size ?: 0
        }

        override fun populate(view: View?, index: Int) {
            (view as? ImageView)?.load(imagesUrl?.get(index))
        }

        override fun onNewItem(index: Int) {
        }

}