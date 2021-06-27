package com.example.animation_with_drawable_resources

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnStart: Button = findViewById(R.id.btnStart)
        val img: ImageView = findViewById(R.id.imageView)

        btnStart.setOnClickListener {
            val animation1 = AnimationUtils.loadAnimation(this, R.anim.animate_one)
            val animation2 = AnimationUtils.loadAnimation(this, R.anim.animate_two)
            animation1.duration = 5000
            animation2.duration = 6000
            it.startAnimation(animation1)
            img.startAnimation(animation2)
        }
    }
}