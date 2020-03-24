package dev.sanggi.part2_6

import android.os.Bundle
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.widget.CompoundButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_lab6_1.*

class Lab6_1Activity : AppCompatActivity(), View.OnClickListener,
    CompoundButton.OnCheckedChangeListener {

    /*
    Part2_6 델리게이션 이벤트 모델

    스마트폰에서 화면에 발생하는 사용자 이벤트는 크게 두가지 모델로 나누어 볼 수 있다.
    - 델리게이션 이벤트 모델: 뷰에서 발생하는 이벤트를 처리하기 위한 모델
    - 하이어라키 이벤트 모델: 액티비티에서 발생하는 사용자의 터치나 키 이벤트를 직접 처리하기 위한 모델

    # 델리게이션 이벤트 모델: 이벤트 소스와 이벤트 핸들러를 리스너로 연결하여 처리하는 구조
    - 이벤트처리
        @OnClickListener: 뷰 클릭 시 발생하는 이벤트
        @OnLongClickListener: 뷰를 오래 클릭했을 때 발생하는 이벤트
        @OnCheckedChangeListener: CheckBox의 상태 변경 이벤트
        @OnItemClickListener: ListView의 항목 선택 이벤트
        @OnDateSetListener: DatePicker의 날짜 선택 이벤트
        @OnTimeSetListener: TimePicker의 시간 선택 이벤트

     #하이어라키 이벤트 모델: 액티비티가 화면에 출력되었을 때 발생하는 사용자의 키 이벤트와 화면 터치 이벤트를 처리하기 위한 모델
     - 이벤트처리
        @onTouchEvent: 액티비티에 보이는 내용을 사용자가 손가락으로 조작하는 일을 처리
            - ACTION_DOWN: 터치된 순간의 이벤트
            - ACTION_UP: 터치를 떼는 순간의 이벤트
            - ACTIVE_MOVE: 터치한 후 이동하는 순간의 이벤트
        @onKeyDown:
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab6_1)

        bell.setOnClickListener(this)
        label.setOnClickListener(this)

        repeatCheck.setOnCheckedChangeListener(this)
        vibrate.setOnCheckedChangeListener(this)
        onOff.setOnCheckedChangeListener(this)
    }


    private fun showToast(message: String) =
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

    /** 델리게이션 이벤트 */

    // 체크 이벤트
    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        when (buttonView) {
            repeatCheck -> showToast("repeat is $isChecked")
            vibrate -> showToast("vibrate is $isChecked")
            onOff -> showToast("switch is $isChecked")
        }
    }

    // 클릭 이벤트
    override fun onClick(v: View?) {
        when (v) {
            bell -> showToast("벨 텍스트 클릭 이벤트...")
            label -> showToast("라벨 텍스트 클릭 이벤트...")
        }
    }

    /** 하이어라키 이벤트 */

    var initX: Float = 0f

    // 터치 이벤트
    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> initX = event.x
            MotionEvent.ACTION_UP -> {
                var diffX = initX - event.rawX
                if (diffX > 30)
                    showToast("화면을 왼쪽으로 밀었습니다.")
                else if (diffX < -30)
                    showToast("화면을 오른쪽으로 밀었습니다.")
            }
        }
        return true
    }

    var initTime: Long = 0;

    // 키 다운 이벤트
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {

        when (keyCode) {
            KeyEvent.KEYCODE_BACK -> {
                if (System.currentTimeMillis() - initTime > 3000) {
                    showToast("종료하려면 한번 더 누르세요.")
                    initTime = System.currentTimeMillis()
                } else finish()
            }
        }

        return true
    }

    // 뒤로가기 키 이벤트
    override fun onBackPressed() {

        super.onBackPressed()
    }

}
