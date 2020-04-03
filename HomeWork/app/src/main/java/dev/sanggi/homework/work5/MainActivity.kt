package dev.sanggi.homework.work5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.sanggi.homework.R
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_work5_main.*

class MainActivity : AppCompatActivity() {

    var realm: Realm? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work5_main)

        member_recyclerview.adapter = null
        member_recyclerview.layoutManager = null

        Realm.init(this)
        realm = Realm.getDefaultInstance()

        var members = realm?.where(Member::class.java)?.findAll()

        start_member_btn.setOnClickListener {
            startActivity(Intent(this, AddMemberActivity::class.java))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        realm?.close()
    }

}
