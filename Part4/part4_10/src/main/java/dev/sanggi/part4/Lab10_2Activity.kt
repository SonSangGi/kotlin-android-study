package dev.sanggi.part4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_lab10_2.*

class Lab10_2Activity : AppCompatActivity() {

    var datas: ArrayList<DriveVO> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab10_2)

        val db = DBHelper(this).writableDatabase
        val cursor = db.rawQuery("select * from tb_drive", null)

        while (cursor.moveToNext()) {
            datas.add(
                DriveVO(
                    cursor.getString(3)
                    , cursor.getString(1)
                    , cursor.getString(2)
                )
            )
        }
        db.close()

        datas.forEach { Log.i("LAB10_2", it.toString()) }

        val adapter = DriverAdapter(this, R.layout.custom_item, datas)
        custom_listview.adapter = adapter

    }
}
