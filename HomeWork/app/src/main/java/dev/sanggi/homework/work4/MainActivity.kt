package dev.sanggi.homework.work4

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.sanggi.homework.R
import dev.sanggi.homework.work4.model.Repo
import dev.sanggi.homework.work4.model.service.ApiClient
import kotlinx.android.synthetic.main.activity_wokr4_recycler_item.view.*
import kotlinx.android.synthetic.main.activity_work4.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.simpleName

    var repoList = arrayListOf<Repo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work4)

        // recycleview setting
        rep_recyclerview.adapter = RepoAdapter()
        rep_recyclerview.layoutManager = LinearLayoutManager(this)
        rep_recyclerview.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        )

        // input text setting
        id_edittext.setOnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER)
                searchGitRepositorys(id_edittext.text.toString())
            true
        }

        searchGitRepositorys(id_edittext.text.toString())
    }

    fun searchGitRepositorys(name: String) {
        ApiClient.getService().getRepos(name).enqueue(object : Callback<ArrayList<Repo>> {
            // 요청 실패 시 호출
            override fun onFailure(call: Call<ArrayList<Repo>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "올바르지 않은 정보입니다.", Toast.LENGTH_LONG).show()
            }

            // 요청 성공 시 호출
            override fun onResponse(
                call: Call<ArrayList<Repo>>,
                response: Response<ArrayList<Repo>>
            ) {
                if (response?.isSuccessful) {
                    repoList = response.body()!!
                    rep_recyclerview.adapter?.notifyDataSetChanged()

                } else Toast.makeText(this@MainActivity, "올바르지 않은 정보입니다.", Toast.LENGTH_LONG).show()
            }
        })

    }

    inner class RepoAdapter :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {

        override fun getItemCount(): Int = repoList.size

        // recyclerView 가 초기화 될 때 호출되는 함수
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            // 미리 작성한 layout.xml을 View로 생성
            var view = LayoutInflater.from(parent.context)
                .inflate(R.layout.activity_wokr4_recycler_item, parent, false)

            return Holder(view)
        }

        // 추상클래스 ViewHolder를 Class로 정의
        inner class Holder(view: View) : RecyclerView.ViewHolder(view)

        // View가 생성될 때 호출되는 함수
        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            var viewHolder = holder.itemView

            viewHolder.name_textview.text = repoList[position].owner.login

            Glide.with(holder.itemView.context).load(repoList[position].owner.avatarUrl).into(viewHolder.profile_imageview)

            viewHolder.fullname_textview.text = repoList[position].fullName

            viewHolder.update_textview.text = repoList[position].updatedAt

            viewHolder.url_textview.text = repoList[position].url
        }
    }
}

