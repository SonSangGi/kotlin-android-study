package dev.sanggi.homework.work3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import dev.sanggi.homework.R
import kotlinx.android.synthetic.main.activity_work3_main4.*

class Main4Activity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work3_main4)

        btn_work4.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        val id = work3_id.text.toString()
        val pwd = work3_pwd.text.toString()

        if (id.isEmpty() || pwd.isEmpty()) {
            Toast.makeText(this, "입력 덜 됐음", Toast.LENGTH_SHORT).show()
            return
        }
        Toast.makeText(this, "ID: $id PWD: $pwd", Toast.LENGTH_SHORT).show()

    }
}
