package dev.sanggi.part3_9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import kotlinx.android.synthetic.main.activity_readfile.*
import java.io.File
import java.nio.charset.Charset

class ReadFileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_readfile)

        //val file = File(Environment.getExternalStorageDirectory().absolutePath.plus("/myApp/myfile.txt"))
        val dir = getExternalFilesDir("aad")
        val file = File("$dir/myfile.txt")

        Log.i("파일 읽음", "$file ${file.exists()}")

        var line = ""

        file.readLines().forEach {
            line += it.plus("\n")
        }

        Log.i("라인", line)

        read_content.text = line
    }
}
