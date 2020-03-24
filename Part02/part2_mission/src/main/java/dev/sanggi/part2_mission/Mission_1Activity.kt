package dev.sanggi.part2_mission

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_mission_1.*

class Mission_1Activity : AppCompatActivity(), View.OnClickListener {

    /*
    Part2 도전 과제1 - 페이스북의 메신저 인트로 화면 구성

    요구사항
    1. 사용자 인터페이스
        - 레이아웃 XML파일을 이용해 작성, 이미지, 타이틀 문자열 ,콘텐츠 문자열, 버튼 설정 문자열 출력
        - 버튼 클릭 시 "ok button click~~" 이라는 문자열을 toast로 출력한다.
    2. 화면 전환에 대응
        - 세로 방향은 모든 내용을 출력하며, 가로 방향에서는 이미지를 출력하지 않는다.
        - 세로 방향과 가로 방향의 레이아웃을 각각의 XML 파일로 작성하여 대응할 것
    3. 국제화에 대응
        - 스마트폰 locale이 ko이면 한국어로 출력하며, en이면 문자열을 영어로 출력한다.

    * 필요 기술
        - 레이아웃 구성
        - 화면 회전에 따른 UI 교체
        - 문자열 리소스 국제화
        - 버튼 클릭 이벤트
        - 토스트 출력
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mission_1)

        btn_ok.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            btn_ok -> Toast.makeText(this, "ok button click ~~", Toast.LENGTH_SHORT).show()
        }
    }
}
