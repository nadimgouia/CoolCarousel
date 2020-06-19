package com.ndroid.coolcarousel

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.layout_carousel.view.*


class Carousel : LinearLayout {

    lateinit var carouselView : View
    lateinit var previewImage: Drawable
    var showIndicators = false
        set(value) {
            field = value
            init(context)
        }
    var currentImageIndex = 0
    var images: IntArray = intArrayOf()
        set(value) {
            field = value
            init(context)
        }

    constructor(context: Context) : super(context) {
        init(context)
    }

    private fun init(context: Context) {
        carouselView =
            LayoutInflater.from(context).inflate(R.layout.layout_carousel, this, true)
        carouselView.ivMainImage.setImageDrawable(previewImage)

        if (showIndicators)
            setIndicators(carouselView.layoutIndicators)

        carouselView.ivArrowLeft.setOnClickListener {
            carouselView.layoutIndicators.getChildAt(currentImageIndex).setBackgroundResource(R.drawable.circle_black)
            if (currentImageIndex == 0)
                currentImageIndex = images.size - 1
            else
                currentImageIndex--
            carouselView.ivMainImage.setImageResource(images[currentImageIndex])
            carouselView.layoutIndicators.getChildAt(currentImageIndex).setBackgroundResource(R.drawable.circle_white)
        }

        carouselView.ivArrowRight.setOnClickListener {
            carouselView.layoutIndicators.getChildAt(currentImageIndex).setBackgroundResource(R.drawable.circle_black)
            if (currentImageIndex == images.size - 1)
                currentImageIndex = 0
            else
                currentImageIndex++
            carouselView.ivMainImage.setImageResource(images[currentImageIndex])
            carouselView.layoutIndicators.getChildAt(currentImageIndex).setBackgroundResource(R.drawable.circle_white)
        }
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {

        val attributes = context.obtainStyledAttributes(
            attrs, R.styleable.carousel_attributes, 0, 0
        )

        previewImage = attributes.getDrawable(R.styleable.carousel_attributes_preview_image)!!
        showIndicators =
            attributes.getBoolean(R.styleable.carousel_attributes_show_indicators, false)

        attributes.recycle()

        init(context)
    }


    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        var ivParams = carouselView.ivMainImage.layoutParams
        ivParams.height = carouselView.layoutParams.height
        ivParams.width = ViewGroup.LayoutParams.MATCH_PARENT
        carouselView.ivMainImage.layoutParams = ivParams

        carouselView.layoutParams = LayoutParams(LayoutParams.MATCH_PARENT,
            LayoutParams.WRAP_CONTENT)

    }
    private fun generateView(isCurrent: Boolean): View {
        val indicatorView = View(context)
        val sizeInDP: Int = pxToDp(15)
        val marginInDP: Int = pxToDp(5)
        val params = LayoutParams(sizeInDP, sizeInDP)
        params.setMargins(marginInDP, marginInDP, marginInDP, marginInDP)
        indicatorView.layoutParams = params
        if (isCurrent)
            indicatorView.setBackgroundResource(R.drawable.circle_white)
        else
            indicatorView.setBackgroundResource(R.drawable.circle_black)
        return indicatorView
    }

    private fun setIndicators(layoutIndicators: LinearLayout) {
        for (i in images.indices) {
            var isCurrent = false
            if (i == currentImageIndex)
                isCurrent = true
            val view = generateView(isCurrent)
            Log.d("setIndicators", "addView");
            layoutIndicators.addView(view)
        }
    }

    // this method convert pixel to DP
    private fun pxToDp(sizePx: Int): Int {
        val density = resources.displayMetrics.density
        val dp = sizePx * density
        return dp.toInt()
    }
}