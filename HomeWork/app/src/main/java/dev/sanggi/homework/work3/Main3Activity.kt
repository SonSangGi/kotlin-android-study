package dev.sanggi.homework.work3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import dev.sanggi.homework.R
import kotlinx.android.synthetic.main.activity_work3_main3.*

class Main3Activity : AppCompatActivity(),View.OnClickListener {

    /**
     * 1. 세로로 RGB
     * 2. 가로로 RGB
     * 3. 2 1 2 각각 색상 다르게
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work3_main3)

        btn_work3.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        startActivity(Intent(this, Main4Activity::class.java))
        finish()
    }
}
