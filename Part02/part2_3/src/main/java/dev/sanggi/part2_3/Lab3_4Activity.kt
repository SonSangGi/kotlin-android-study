package dev.sanggi.part2_3

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import kotlinx.android.synthetic.main.activity_lab3_4.*

class Lab3_4Activity : AppCompatActivity() {

    /**
     * 사용자 인터페이스
     * - view 활용
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab3_4)

        // custom font 설정
        fontView.typeface = Typeface.createFromAsset(assets, "xmas.ttf")

        // 체크박스 이벤트
        checkbox.setOnCheckedChangeListener { buttonView, isChecked ->
            checkbox.text = if (isChecked) "is checked" else "is unChecked"
        }

    }
}
