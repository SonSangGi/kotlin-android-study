package dev.sanggi.part3_mission

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_add.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val name = edit_name.text.toString()
        val email = edit_email.text.toString()
        val phone = edit_phone.text.toString()

        if (name.isEmpty() || email.isEmpty() || phone.isEmpty()) {
            showToast("모두 입력해주세요.")
            return
        }

        val db = DBHelper(this).writableDatabase

        db.insert("tb_contact", null, ContentValues().apply {
            put("name", name)
            put("email", email)
            put("phone", phone)
        })

        startActivity(Intent(this,ResultActivity::class.java))

    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
