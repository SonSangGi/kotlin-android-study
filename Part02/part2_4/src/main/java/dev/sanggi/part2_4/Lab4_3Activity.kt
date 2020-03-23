package dev.sanggi.part2_4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import kotlinx.android.synthetic.main.activity_lab4_3.*

class Lab4_3Activity : AppCompatActivity() {

    /*
    Part2 4-3 FrameLayout

    - 레이아웃에 포함된 뷰들을 같은 영역에 겹쳐서 배치할 때 사용
    - 같은 영역에 여러 뷰를 겹치게 한다음, 한순간에 하나의 뷰만 보이기 위함 (visible 속성 사용)

    ! TabHost : 탭화면 구현
    - 안드로이드 UI 프로그램에서 가장 많이 제공하는 화면 중 하나
    - 탭화면을 여러 개 준비한 다음, 사용자가 버튼을 누를 때 버튼과 연결된 화면을 보여주는 형식

    @ TabHost: 탭 전체 영역을 지칭
    @ TabWidget: 탭 버튼이 들어갈 영역을 지칭
    @ FrameLayout: 탭 버튼 클릭 시 나올 화면 영역을 지칭

    탭 화면을 만들기 위해선 전체 영역을 TabHost로 감싸고
    그안에 버튼이 들어갈 영역 TabWidget과
    보일 화면인 FrameLayout을 지정해야함

    ! @android:id 를 사용하는 이유: 라이브러리의 R.java 파일을 사용하기 위해
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab4_3)

        host.setup() // TabHost 하의의 TabWidget과 FrameLayout 획득

        var spec = host.newTabSpec("tab1");
        spec.setIndicator(
            null, ResourcesCompat.getDrawable(
                resources, R.drawable.tab_icon1, null
            )
        )
        spec.setContent(R.id.tab_content1)
        host.addTab(spec)

        spec = host.newTabSpec("tab2");
        spec.setIndicator(
            null, ResourcesCompat.getDrawable(
                resources, R.drawable.tab_icon2, null
            )
        )
        spec.setContent(R.id.tab_content2)
        host.addTab(spec)

        spec = host.newTabSpec("tab3");
        spec.setIndicator(
            null, ResourcesCompat.getDrawable(
                resources, R.drawable.tab_icon3, null
            )
        )
        spec.setContent(R.id.tab_content3)
        host.addTab(spec)

    }
}
