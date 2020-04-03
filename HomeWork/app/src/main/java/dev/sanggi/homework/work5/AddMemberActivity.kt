package dev.sanggi.homework.work5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import dev.sanggi.homework.R
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_work5_add_member.*

class AddMemberActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work5_add_member)

        val mRealm = Realm.getDefaultInstance()

        add_member_btn.setOnClickListener {
            if (member_id_edittext.text.isEmpty() || member_pwd_edittext.text.isEmpty())
                Toast.makeText(this, "모두 입력하세요.", Toast.LENGTH_LONG)
            else {
                mRealm.executeTransaction { realm ->
                    val member = realm.createObject(Member::class.java)
                    member.id = member_id_edittext.text.toString()
                    member.password = member_pwd_edittext.text.toString()
                }
            }
        }

        var members = mRealm.where(Member::class.java)?.findAll()
        members?.forEach { Log.i("TAG", it.toString()) }
    }
}
