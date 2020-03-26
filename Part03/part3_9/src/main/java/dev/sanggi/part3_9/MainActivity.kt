package dev.sanggi.part3_9

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var fileReadPermission = false
    private var fileWritePermission = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn.setOnClickListener(this)

        checkPermissions()

    }

    override fun onClick(v: View?) {

        if (fileReadPermission && fileWritePermission) {
            // getExternalStorageDirectory 외부 저장소 최상위 경로라 최근 버전에선 접근이 불가능함.
            // getExternalFilesDir()은 해당 앱의 외부 저장소 파일을 리턴함 (어플리케이션의 고유 영역) 인자로 디렉토리 유형을 넘겨준다.
            // val dirPath = Environment.getExternalStorageDirectory().absolutePath.plus("/myApp")
            val dir = getExternalFilesDir("/myApp")
            val file = File("$dir/myfile.txt")

            Log.i("TAG", "$dir")

            if (!file.exists()) file.createNewFile()

            file.writeText(content.text.toString())

            startActivity(Intent(this, ReadFileActivity::class.java))
        } else
            Toast.makeText(this, "권한부여가 되지 않아 실행할 수 없습니다.", Toast.LENGTH_SHORT).show()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == 200 && grantResults.isNotEmpty()) {
            fileReadPermission = grantResults[0] == PackageManager.PERMISSION_GRANTED
            fileWritePermission = grantResults[1] == PackageManager.PERMISSION_GRANTED
        }

        Log.i("TAG", "PERMISSION >> READ:$fileReadPermission WRITE: $fileWritePermission")
    }

    private fun checkPermissions() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)
            fileReadPermission = true
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)
            fileWritePermission = true

        if (!fileReadPermission || !fileWritePermission)
            ActivityCompat.requestPermissions(
                this, arrayOf(
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                ), 200
            )
    }

}
