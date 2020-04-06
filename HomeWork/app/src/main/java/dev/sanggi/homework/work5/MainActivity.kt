package dev.sanggi.homework.work5

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.sanggi.homework.R
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.RealmResults
import io.realm.Sort
import kotlinx.android.synthetic.main.activity_wokr4_recycler_item.view.*
import kotlinx.android.synthetic.main.activity_work5_item.view.*
import kotlinx.android.synthetic.main.activity_work5_main.*

class MainActivity : AppCompatActivity() {

    val ADD_MEMBER_REQUEST = 0
    var realm: Realm? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work5_main)


        Realm.init(this)
        realm = Realm.getDefaultInstance()
        val memberList = realm?.where(Member::class.java)?.findAll()!!.sort("idx", Sort.DESCENDING)

        member_recyclerview.adapter = MemberAdapter(memberList!!)
        member_recyclerview.layoutManager = LinearLayoutManager(this)

        start_member_btn.setOnClickListener {
            startActivityForResult(Intent(this, AddMemberActivity::class.java), ADD_MEMBER_REQUEST)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            ADD_MEMBER_REQUEST -> member_recyclerview.adapter?.notifyDataSetChanged()
        }
    }

    override fun onDestroy() {
        realm?.close()
        super.onDestroy()
    }

    inner class MemberAdapter(private val memberList: RealmResults<Member>) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {

        override fun getItemCount(): Int = memberList.size

        inner class Holder(view: View) : RecyclerView.ViewHolder(view)

        // 초기화시
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            var view = LayoutInflater.from(parent.context)
                .inflate(R.layout.activity_work5_item, parent, false)

            view.setOnClickListener {
                Toast.makeText(view.context, view.work5_item_id.text, Toast.LENGTH_SHORT).show()

                val member = realm!!.where(Member::class.java)
                    .equalTo("idx", Integer.parseInt(view.work5_item_idx.text.toString()))
                    .findFirst()

                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra("member", member)

                startActivity(intent)
            }
            return this.Holder(view)
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            var viewHolder = holder.itemView

            Glide.with(holder.itemView.context).load("https://i.picsum.photos/id/${memberList[position].idx}/50/50.jpg").into(viewHolder.work5_item_imageview)

            viewHolder.work5_item_idx.text = memberList[position].idx.toString()

            viewHolder.work5_item_id.text = memberList[position].id

            viewHolder.work5_item_pwd.text = memberList[position].password
        }
    }

}
