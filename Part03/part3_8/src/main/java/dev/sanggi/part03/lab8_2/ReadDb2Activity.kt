package dev.sanggi.part03.lab8_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.sanggi.part03.R
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_read_db2.*

class ReadDb2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read_db2)

        val intent = intent
        val title = intent.getStringExtra("title")

        val mRealm = Realm.getDefaultInstance()
        var vo = mRealm.where(MemoVO::class.java).equalTo("title", title).findFirst()
        realm_read_title.text = vo.title
        realm_read_content.text = vo.content
    }
}
