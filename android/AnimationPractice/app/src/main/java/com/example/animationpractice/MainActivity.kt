package com.example.animationpractice

import android.media.FaceDetector
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Fade
import android.transition.Transition
import android.transition.TransitionManager
import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.Group

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button2 = findViewById<Button>(R.id.button2)
        val group = findViewById<Group>(R.id.group)
        val viewGroup = findViewById<ConstraintLayout>(R.id.viewGroup)
        button2.setOnClickListener {
            button2.visibility = View.GONE
            val transition: Transition = Fade()
            transition.duration = 2000L
            TransitionManager.beginDelayedTransition(viewGroup, transition)
            group.visibility = View.VISIBLE
        }
    }
}