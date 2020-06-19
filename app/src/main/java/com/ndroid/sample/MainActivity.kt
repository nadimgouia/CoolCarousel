package com.ndroid.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var imagesArray : IntArray

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imagesArray = intArrayOf(R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4)
        carousel.images = imagesArray
        carousel.showIndicators = true
    }


}
