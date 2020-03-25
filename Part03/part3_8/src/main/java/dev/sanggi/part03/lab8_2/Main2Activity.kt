package dev.sanggi.part03.lab8_2

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import dev.sanggi.part03.R
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        realm_add_btn.setOnClickListener(this)

    }

    override fun onClick(v: View?) {

        val title = realm_add_title.text.toString()
        val content = realm_add_content.text.toString()

        Realm.init(this)
        val mRealm = Realm.getDefaultInstance()
        mRealm.executeTransaction { realm ->
            val vo = realm.createObject(MemoVO::class.java)
            vo.title = title
            vo.content = content
        }

        val intent = Intent(this, ReadDb2Activity::class.java)
        intent.putExtra("title", title)

        startActivity(intent)
    }

}
