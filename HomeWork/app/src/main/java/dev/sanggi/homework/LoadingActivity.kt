package dev.sanggi.homework

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_loading.*

class LoadingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)

        Thread(Runnable {
            for (i in 0..100) {
                println(i)
                progress.progress += 1
                Thread.sleep(20)

                if (i == 100) {
                    //startActivity(Intent(this, MapActivity::class.java))
                    finish()
                }
            }
        }).start()

        /*Handler().postDelayed({

        }, 2000)*/
    }
}
