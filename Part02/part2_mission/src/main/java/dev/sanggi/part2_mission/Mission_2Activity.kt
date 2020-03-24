package dev.sanggi.part2_mission

import android.os.Bundle
import android.view.KeyEvent
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class Mission_2Activity : AppCompatActivity() {

    /* Part2 도전 과제2 - 브런치 앱의 새 글 작성 화면 및 앱 종료 다이얼로그 띄우기

    * 필요 기술
    - 레이아웃 구성
    - EditText의 입력 줄 수 제어
    - 키보드와 상관없이 특정 뷰를 화면 하단에 고정
    - 뒤로가기 버튼 제어
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mission_2)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {

        if (keyCode == KeyEvent.KEYCODE_BACK)
            AlertDialog.Builder(this)
                .setMessage("작성중인 내용을 저장하지 않고 종료하시겠습니까?")
                .setNegativeButton("확인"){dialog, which -> finish() }
                .setPositiveButton("취소",null)
                .create()
                .show()

        return true
    }
}
