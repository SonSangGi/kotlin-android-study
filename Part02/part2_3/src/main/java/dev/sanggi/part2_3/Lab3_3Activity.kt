package dev.sanggi.part2_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_lab3_3.*

class Lab3_3Activity : AppCompatActivity(), View.OnClickListener {

    /**
     * 뷰 기초 속성 활용
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab3_3)

        // 버튼 클릭 리스너 등록
        btn_visible_true.setOnClickListener(this)
        btn_visible_false.setOnClickListener(this)

    }

    // 버튼 클릭 이벤트 (View.onClickListener implement)
    override fun onClick(view: View) {
        println("CLICK")
        when (view.id) {
            R.id.btn_visible_true -> text_visible_target.visibility = View.VISIBLE
            R.id.btn_visible_false -> text_visible_target.visibility = View.INVISIBLE
        }
    }

}
