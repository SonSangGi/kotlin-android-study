package dev.sanggi.homework.work5

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import dev.sanggi.homework.R
import io.realm.Realm
import io.realm.RealmConfiguration
import kotlinx.android.synthetic.main.activity_work5_add_member.*

class AddMemberActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work5_add_member)

        val realm = Realm.getDefaultInstance()

        add_member_btn.setOnClickListener {
            if (member_id_edittext.text.isEmpty() || member_pwd_edittext.text.isEmpty())
                Toast.makeText(this, "모두 입력하세요.", Toast.LENGTH_LONG).show()
            else {
                realm.executeTransaction { realm ->
                    val currentIdx = realm.where(Member::class.java).max("idx")
                    val nextIdx = if (currentIdx == null) 0 else currentIdx.toLong() + 1

                    val member = Member()
                    member.idx = nextIdx
                    member.id = member_id_edittext.text.toString()
                    member.password = member_pwd_edittext.text.toString()

                    realm.copyToRealm(member)

                    Toast.makeText(this, "${member.id}: 생성되었습니다.", Toast.LENGTH_LONG).show()

                    val intent = Intent()
                    intent.putExtra("member", member)
                    setResult(Activity.RESULT_OK, intent)
                    finish()
                }
            }
        }

    }
}
