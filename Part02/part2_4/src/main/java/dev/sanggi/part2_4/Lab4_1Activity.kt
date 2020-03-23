package dev.sanggi.part2_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Lab4_1Activity : AppCompatActivity() {

    /*
    Part2 4-1 LinearLayout

    - 가장 많이 이용되는 레이아웃 중 하나
    - 해당 레이아웃에 포함된 뷰를 순서대로 가로나 세로 방향으로 나열
    - 다른 레이아웃에는 없는 orientation 으로 기준을 정함

    @ orientation: horizontal, vertical - 가로, 세로 나열

    @ 안드로이드에서 뷰의 정렬과 관련된 속성은 gravity와 layout_gravity 두가지이다.
    gravity: 뷰의 내용을 뷰영역 내에서 어디세 나타낼지 설정
    layout_gravity: 뷰를 linearLayout영역 내에서 어디에 나타낼지 설정

    @ weight 속성은 가로나 세로 방향으로 생기는 여백을 뷰들이 확장해서 차지하게 할 때 사용

     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab4_1)
    }
}
