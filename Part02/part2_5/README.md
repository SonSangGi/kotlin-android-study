# PART2_5 다양한 사용자 알림 효과

###  Part2_5 진동, 소리 울리기

``` kotlin
override fun onClick(v: View?) {
    when (v) {
        btn_vibration ->
            (getSystemService(Context.VIBRATOR_SERVICE) as Vibrator).vibrate(1000)

        btn_system_beep -> {
            val notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
            val ringtone = RingtoneManager.getRingtone(applicationContext, notification)
            ringtone.play()
        }

        btn_custom_sound ->
            MediaPlayer.create(this, R.raw.fallbackring).start()
    }
}
```

###  Part 2_5 다이얼 로그
- 모달: 다이얼로그를 닫기 전까지 원래의 창을 사용자가 이용할 수 없음
- 모달리스: 다이얼로그가 화면에 떠 있어도 사용자가 원래의 창을 이용할 수 있음

```
#1 Toast : 화면 하단에 검정색 바탕의 흰색 글이 잠깐 보였다 사라지는 다이얼로그
#2 알림창(AlertDialog) : 사용자에게 메세지확인을 강제하는 알림창
#3 목록(AlertDialog) : 목록 형식의 다이얼 로그
#4 날짜 선택(DatePickerDialog) : 사용자가 날짜를 선택하는 알림창
#5 시간 선택(TimePickerDialog) : 사용자가 시간을 선택하는 알림창
```
