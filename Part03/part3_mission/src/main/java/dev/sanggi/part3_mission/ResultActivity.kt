package dev.sanggi.part3_mission

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)


        val db= DBHelper(this).writableDatabase

        val cursor = db.rawQuery("select name, email, phone from tb_contact order by _id desc limit 1", null)

        while (cursor.moveToNext()) {
            result_name.text = cursor.getString(0)
            result_email.text = cursor.getString(1)
            result_phone.text = cursor.getString(2)
        }
    }
}
