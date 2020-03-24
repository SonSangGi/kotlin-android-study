package dev.sanggi.part2_7

import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_lab7_1.*

class Lab7_1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab7_1)

        val anim = AnimationUtils.loadAnimation(this, R.anim.`in`)
        val anim2 = AnimationUtils.loadAnimation(this, R.anim.move)
        anim.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {}

            override fun onAnimationEnd(animation: Animation?) {
                anim2.fillAfter = true
                img.startAnimation(anim2)
            }

            override fun onAnimationRepeat(animation: Animation?) {}
        })

        img.startAnimation(anim)
    }
}
