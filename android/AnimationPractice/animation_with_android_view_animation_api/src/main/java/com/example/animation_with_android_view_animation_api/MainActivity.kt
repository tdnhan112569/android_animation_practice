package com.example.animation_with_android_view_animation_api

import android.content.res.Resources
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.animation.*
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    lateinit var button: Button
    lateinit var rotateAnimation: RotateAnimation
    lateinit var scaleAnimation: ScaleAnimation
    lateinit var translateAnimation: TranslateAnimation
    lateinit var interpolatorAnimation: TranslateAnimation
    lateinit var animationSet: AnimationSet

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.button)
        animationSet = AnimationSet(this, null)
        val metrics: DisplayMetrics = Resources.getSystem().displayMetrics
        val xPoint = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 100f, metrics)
        val yPoint = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 35f, metrics)
        rotateAnimation = RotateAnimation(0f, 360F, xPoint, yPoint)
        rotateAnimation.repeatCount = Animation.INFINITE
        rotateAnimation.repeatMode = Animation.RESTART
        rotateAnimation.interpolator = LinearInterpolator()
        //rotateAnimation.duration = 1000L


        translateAnimation = TranslateAnimation(0f, 100f, 0f, 100f)
        scaleAnimation = ScaleAnimation(-2f, 2f, -2f, 2f)
        scaleAnimation.repeatCount = Animation.INFINITE
        scaleAnimation.repeatMode = Animation.REVERSE
        //animationSet.addAnimation(scaleAnimation)
        //animationSet.addAnimation(translateAnimation)
        animationSet.addAnimation(rotateAnimation)
        animationSet.duration = 1000L
//        animationSet.repeatMode = Animation.INFINITE
//        animationSet.repeatCount = Animation.INFINITE
        animationSet.interpolator = LinearInterpolator()


        button.setOnClickListener {
            it.startAnimation(animationSet)
        }
    }
}