package dev.sanggi.part3_9

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class SharedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared)

        val sharedPref = getSharedPreferences("my_prefs", Context.MODE_PRIVATE)
        sharedPref.edit().putString("키!", "밸류~").commit()

        val str = sharedPref.getString("키!", "")

        Log.i("SHARED DATA", str)
    }
}
