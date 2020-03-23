package dev.sanggi.part2_5

import android.content.Context
import android.media.MediaPlayer
import android.media.RingtoneManager
import android.os.Bundle
import android.os.Vibrator
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_lab5_1.*

class Lab5_1Activity : AppCompatActivity(), View.OnClickListener {

    /*
    Part2_5 진동, 소리 울리기
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab5_1)

        btn_vibration.setOnClickListener(this)
        btn_system_beep.setOnClickListener(this)
        btn_custom_sound.setOnClickListener(this)

    }


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

}
