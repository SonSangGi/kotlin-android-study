package dev.sanggi.part03.lab8_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import dev.sanggi.part03.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        add_btn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val title = add_title.text.toString()
        val content = add_content.text.toString()

        val helper = DBHelper(this)
        val db = helper.writableDatabase

        db.execSQL("insert into tb_memo (title, content) values (?, ?)", arrayOf(title, content))
        db.close()

        startActivity(Intent(this, ReadDBActivity::class.java))
    }
}
