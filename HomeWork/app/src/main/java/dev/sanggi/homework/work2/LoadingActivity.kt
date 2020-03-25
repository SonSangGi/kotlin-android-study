package dev.sanggi.homework.work2

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.widget.Toast
import dev.sanggi.homework.R
import kotlinx.android.synthetic.main.activity_work2_loading.*

class LoadingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work2_loading)

        progress(0)

        // color set
        val ssb = SpannableStringBuilder(work2_logo.text.toString())
        ssb.setSpan(
            ForegroundColorSpan(Color.parseColor("#E60000")),
            1,
            2,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        work2_logo.text = ssb
    }

    private fun progress(i: Int) {

        if (i == 100) {
            Toast.makeText(this, "Hi!", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, ClockActivity::class.java))
            finish()
        } else {
            work2_progress.progress += 1

            Handler().postDelayed({
                progress(i + 1)
            }, 20)
        }
    }
}
