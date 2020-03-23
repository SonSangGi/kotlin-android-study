package dev.sanggi.part2_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Lab4_5Activity : AppCompatActivity() {

    /*
    Part2 4-5 ConstraintLayout

    - RelativeLayout과 비슷함
    - 상대 위치에 따라 뷰의 배치를 제공
    - RelativeLayout보다 상대 위치 속성이 많음

    # 1.상대적 위치 지정
    @app:layout_constraintLeft_toLeftOf
    @app:layout_constraintLeft_toRightOf
    @app:layout_constraintRight_toLeftOf
    @app:layout_constraintRight_toRightOf
    @app:layout_constraintTop_toTopOf
    @app:layout_constraintTop_toBottomOf
    @app:layout_constraintBottom_toTopOf
    @app:layout_constraintBottom_toBottomOf
    @app:layout_constraintBaseline_toBaselineOf
    @app:layout_constraintStart_toEndOf
    @app:layout_constraintStart_toStartOf
    @app:layout_constraintEnd_toStartOf
    @app:layout_constraintEnd_toEndOf

    속성값으로 상대뷰의 id값 혹은 parent라는 단어로 상위 뷰를 지칭

    # 2.여백 (margin) : 뷰와 뷰 사이의 간격을 표현하기 위한 속성들
    @android:layout_marginStart
    @android:layout_marginEnd
    @android:layout_marginLeft
    @android:layout_marginRight
    @android:layout_marginTop
    @android:layout_marginBottom

    상대 뷰가 View.GONE 상태일 때의 margin 값을 따로 설정 가능
    @app:layout_gonMarginStart
    @app:layout_gonMarginEnd
    @app:layout_gonMarginLeft
    @app:layout_gonMarginTop
    @app:layout_gonMarginRight
    @app:layout_gonMarginBottom

    # 3.가운데 맞춤과 치우침 (bias) : 뷰를 부모 중앙에 위치시키지만, 어느 쪽으로 치우쳐서 나오게 하고 싶은 경우 사용
    @app:layout_constraintHorizontal_bias: 가로 치우침 조절
    @app:layout_constraintVertical_bias: 세로 치우침 조절
    값은 실수 타입

    # 4.비율 (Ratio) : 뷰의 크기를 지정할 때 가로세로 비율에 의한 크기를 지정, 크기 값을 0dp로 설정해야함
    @app:layout_constraintDimensionRatio
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab4_5)
    }
}
