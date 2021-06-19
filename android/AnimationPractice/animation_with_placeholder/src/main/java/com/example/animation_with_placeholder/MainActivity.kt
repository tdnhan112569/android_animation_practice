package com.example.animation_with_placeholder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.View
import android.view.animation.AnticipateInterpolator
import android.view.animation.BounceInterpolator
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.Placeholder

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var placeholder: Placeholder
    lateinit var rootLayout: ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val img1 = findViewById<ImageView>(R.id.img1)
        val img2 = findViewById<ImageView>(R.id.img2)
        val img3 = findViewById<ImageView>(R.id.img3)
        img1.setOnClickListener(this)
        img2.setOnClickListener(this)
        img3.setOnClickListener(this)
        rootLayout = findViewById(R.id.rootLayout)
        placeholder = findViewById(R.id.placeHolder)

    }

    override fun onClick(v: View) {
        val transition = ChangeBounds()
        transition.interpolator = BounceInterpolator() //AnticipateInterpolator()
        transition.duration = 2500L
        TransitionManager.beginDelayedTransition(rootLayout, transition)
        placeholder.setContentId(v.id)
    }
}