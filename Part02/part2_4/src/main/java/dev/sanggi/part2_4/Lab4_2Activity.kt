package dev.sanggi.part2_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Lab4_2Activity : AppCompatActivity() {

    /*
    Part2 4-2 RelativeLayout

    - 화면에 이미 배치된 뷰를 기준으로 다른 뷰의 위치를 지정하는 레이아웃
    - 뷰의 상대 위치를 지정하여 배치
    - 자동으로 가로나 세로로 나열하지 않음

    @ android: layout_above: 기존 뷰의 윗부분에 위치
    @ android: layout_below: 기존 뷰의 아랫부분에 배치
    @ android: layout_toLeftOf: 기존 뷰의 왼쪽에 위치
    @ android: layout_toRightOf: 기존 뷰의 오른쪽에 배치

    @ android: layout_alignTop: 기준 뷰와 윗부분을 정렬
    @ android: layout_alignBottom: 기준뷰와 아랫부분을 정렬
    @ android: layout_alignLeft: 기준뷰와 왼쪽을 정렬
    @ android: layout_alignRight: 기준뷰와 오른쪽을 정렬
    @ android: layout_alignBaseline: 기준뷰와 텍스트 기준선을 정

    @ android: layout_alignParentTop: 부모의 윗부분에 뷰의 상단을 위치
    @ android: layout_alignParentBottom: 부모의 아랫부분에 뷰의 하단을 위치
    @ android: layout_alignParentLeft: 부모의 왼쪽에 뷰의 왼쪽을 위치
    @ android: layout_alignParentRight: 부모의 오른쪽에 뷰의 오른쪽을 위치
    @ android: layout_centerHorizontal: 부모의 가로 방향 중앙에 뷰를 위치
    @ android: layout_centerVertical: 부모의 세로 방향 중앙에 뷰를 위치
    @ android: layout_centerInParent: 부모의 가로세로 중앙에 뷰를 위치

    ** LinearLayout 보다 RelativeLayout 으로 개발하는 경우가 더 많음
    
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab4_2)
    }
}
