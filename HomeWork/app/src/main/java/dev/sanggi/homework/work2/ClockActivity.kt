package dev.sanggi.homework.work2

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.jakewharton.threetenabp.AndroidThreeTen
import dev.sanggi.homework.R
import kotlinx.android.synthetic.main.activity_work2_clock.*
import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter
import kotlin.random.Random

class ClockActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work2_clock)
        AndroidThreeTen.init(this)

        tick()

    }

    private fun tick() {

        // datetime set
        work2_datetime.text =
            LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))

        // color set
        color_view.setBackgroundColor(
            Color.rgb(
                Random.nextInt(),
                Random.nextInt(),
                Random.nextInt()
            )
        )

        // callback
        Handler().postDelayed({
            tick()
        }, 1000)
    }

}
