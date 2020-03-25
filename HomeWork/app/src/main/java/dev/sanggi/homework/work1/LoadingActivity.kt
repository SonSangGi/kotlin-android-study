package dev.sanggi.homework.work1

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dev.sanggi.homework.R
import kotlinx.android.synthetic.main.activity_work1_loading.*
import kotlinx.android.synthetic.main.activity_work2_loading.*

class LoadingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work1_loading)

        handlerLoading()

    }

    private fun threadLoading() {
        Thread(Runnable {
            for (i in 0..100) {
                progress.progress += 1
                Thread.sleep(20)

                if (i == 100) {
                    startActivity(Intent(this, MapActivity::class.java))
                    finish()
                }
            }
        }).start()
    }

    private fun handlerLoading() {

        for (i in 0..100) {
            Handler().postDelayed({
                progress.progress += 1
                if (i == 100) {
                    startActivity(Intent(this, MapActivity::class.java))
                    finish()
                }
            }, i.toLong() * 10)
        }

    }
}
