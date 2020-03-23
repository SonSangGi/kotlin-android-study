package dev.sanggi.part2_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Lab4_4Activity : AppCompatActivity() {

    /*
    Part2 4-4 TableLayout

    - 뷰를 테이블 구조로 나열하는 레이아웃
    - 대표적으로 계산기 앱 화면

    @ android:shrinkColumns="0,1" : 화면 크기를 벗어나는 경우 인덱스 0,1의 열 크기를 줄임
    @ android:stretchColumns="1": 화면 여백이 발생하는 경우 인덱스 1의 열의 크기를 늘림
    @ android:layout_column="1": 뷰의 위치 지정, 인덱스 1의 위치에 뷰가 위치
    @ android:layout_span="2": 두개의 열을 하나의 뷰가 차지
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab4_4)
    }
}
