# CoolCarousel
CoolCarousel is an android library written with kotlin to facilitate creating Carousel with images. You can move the next previous image by clicking the right and left arrows.

# Gradle
Add library to your dependencies
<pre>
<code>
dependencies {
  implementation 'com.ndroid.coolviews:cool-carousel:1.0.0'
}
</code>
</pre>

# ScreenShot
<a href="https://imgbb.com/"><img src="https://i.ibb.co/rQXHjBK/Capture-d-e-cran-2020-06-20-a-12-57-41.png" alt="Capture-d-e-cran-2020-06-20-a-12-57-41" border="0"></a>
# Sample Example
<a href="https://github.com/nadimgouia/CoolCarousel/tree/master/app">Sample Module</a>

# Usage

To create a new CoolCarousel from XML file
<pre>
<code>
   &lt;com.ndroid.coolcarousel.Carousel
       android:id="@+id/carousel"
       android:layout_width="match_parent"
       android:layout_height="230dp"
       carousel:preview_image="@drawable/image1"
       carousel:show_indicators="true" /&gt;
</code>
</pre>

Setup Carousel images content from the activity class..

Java Version
<pre>
<code>
        // create images array 
        Integer images = new Integer[]{R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4};
        CoolCarousel carousel = findViewById(R.id.carousel);
        //add images array to carousel
        carousel.setImages(images);
        // show indicators cercles
        carousel.setShowIndicators(true);
</code>
</pre>

Kotlin Version
<pre>
<code>
        // create images array 
        val images = intArrayOf(R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4)
        var carousel : CoolCarousel carousel = findViewById(R.id.carousel)
        //add images array to carousel
        carousel.images = images
        // show indicators cercles
        carousel.show_indicators = true
</code>
</pre>







