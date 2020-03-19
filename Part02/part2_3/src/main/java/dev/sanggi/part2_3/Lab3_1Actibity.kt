package dev.sanggi.part2_3

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class Lab3_1Actibity : AppCompatActivity() {

    /**
     * 코드로 layout 생성 및 view 생성
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val linear = LinearLayout(this)

        val btn = Button(this)
        btn.text = "Button 1"
        linear.addView(btn)

        val btn2 = Button(this)
        btn.text = "Button 2"
        linear.addView(btn2)

        setContentView(R.layout.activity_main)
    }
}
