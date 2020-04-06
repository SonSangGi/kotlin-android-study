package dev.sanggi.homework.work5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import dev.sanggi.homework.R
import kotlinx.android.synthetic.main.activity_work5_detail.*
import kotlinx.android.synthetic.main.activity_work5_item.view.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work5_detail)

        val member = intent.getParcelableExtra<Member>("member")

        Glide.with(this).load("https://i.picsum.photos/id/${member.idx}/200/200.jpg").into(detail_profile_imageview)

        detail_profile_id.text = member.id

        detail_profile_pwd.text = member.password
    }
}
