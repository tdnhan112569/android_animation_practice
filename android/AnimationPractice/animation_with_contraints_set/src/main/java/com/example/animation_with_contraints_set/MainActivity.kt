package com.example.animation_with_contraints_set

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.animation.OvershootInterpolator
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rootLayout = findViewById<ConstraintLayout>(R.id.rootLayout)
        findViewById<Button>(R.id.button).setOnClickListener {
            val constraintSet = ConstraintSet()
            constraintSet.clone(this, R.layout.second_key_fame)
            constraintSet.applyTo(rootLayout)
            val transition = ChangeBounds()
            transition.interpolator = OvershootInterpolator()
            transition.duration = 2500L
            TransitionManager.beginDelayedTransition(rootLayout, transition)
        }


    }
}