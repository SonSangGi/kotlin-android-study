package dev.sanggi.part2_5

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_lab5_2.*
import java.time.LocalDateTime
import java.util.*

class Lab5_2Activity : AppCompatActivity(), View.OnClickListener {

    /*
    Part 2_5 다이얼 로그

    - 모달: 다이얼로그를 닫기 전까지 원래의 창을 사용자가 이용할 수 없음
    - 모달리스: 다이얼로그가 화면에 떠 있어도 사용자가 원래의 창을 이용할 수 있음

    #1 Toast : 화면 하단에 검정색 바탕의 흰색 글이 잠깐 보였다 사라지는 다이얼로그
    #2 알림창(AlertDialog) : 사용자에게 메세지확인을 강제하는 알림창
    #3 목록(AlertDialog) : 목록 형식의 다이얼 로그
    #4 날짜 선택(DatePickerDialog) : 사용자가 날짜를 선택하는 알림창
    #5 시간 선택(TimePickerDialog) : 사용자가 시간을 선택하는 알림창
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab5_2)

        btn_alert.setOnClickListener(this)
        btn_list.setOnClickListener(this)
        btn_date.setOnClickListener(this)
        btn_time.setOnClickListener(this)
        btn_custom.setOnClickListener(this)

    }

    private fun showToast(message: String) =
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

    override fun onClick(v: View?) {
        when (v) {
            btn_alert -> {
                // confirm 알림
                AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("알림")
                    .setMessage("정말 종료하시겠습니까")
                    .setPositiveButton("OK") { dialog, which -> showToast("수락하였다.") } // 수락 버튼, 리스너
                    .setNegativeButton("No") { dialog, which -> showToast("거절해버렸다..") } // 취소 버튼, 리스너
                    .setCancelable(false) // 뒤로가기 클릭 시 다이얼로그가 닫히지 않음
                    .create()
                    .show()
            }
            btn_list -> {
                // 목록 알림
                AlertDialog.Builder(this)
                    .setItems(R.array.dialog_array) { dialog, which -> showToast("클릭클릭") }
                    .setTitle("목록 알림")
                    .create()
                    .show()
            }
            btn_date -> {
                // 날짜 선택
                val now = Calendar.getInstance()
                val year = now.get(Calendar.YEAR)
                val month = now.get(Calendar.MONTH)
                val day = now.get(Calendar.DAY_OF_MONTH)
                DatePickerDialog(
                    this,
                    { view, year, month, dayOfMonth -> showToast("$year-$month-$dayOfMonth") },
                    year,
                    month,
                    day
                )
                    .show()
            }
            btn_time -> {
                // 시간 선택
                val now = Calendar.getInstance()
                val hour = now.get(Calendar.HOUR_OF_DAY)
                val minute = now.get(Calendar.MINUTE)
                TimePickerDialog(
                    this,
                    { view, hourOfDay, minute -> showToast("$hourOfDay:$minute") },
                    hour,
                    minute,
                    true
                ) // true 24 false 12
                    .show()

            }
            btn_custom -> {
                val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                AlertDialog.Builder(this)
                    .setView(inflater.inflate(R.layout.dialog_layout, null))
                    .setPositiveButton("확인") { dialog, which -> showToast("custom dialog 확인 클릭!") }
                    .setNegativeButton("취소", null)
                    .create()
                    .show()
            }
        }
    }
}
