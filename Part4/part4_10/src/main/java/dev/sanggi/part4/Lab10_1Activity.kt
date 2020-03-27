package dev.sanggi.part4

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_lab10_1.*

class Lab10_1Activity : AppCompatActivity(), AdapterView.OnItemClickListener {

    lateinit var arrayDatas: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab10_1)

        arrayDatas = resources.getStringArray(R.array.location)

        arrayDatas.forEach { Log.i("T", it) }
        main_listview_array.adapter =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayDatas)
        main_listview_array.onItemClickListener = this

        val simpledatas = arrayListOf<HashMap<String, String>>()
        val helper = DBHelper(this)
        val db = helper.writableDatabase
        val cursor = db.rawQuery("select * from tb_data", null)
        while (cursor.moveToNext())
            simpledatas.add(
                hashMapOf(
                    "name" to cursor.getString(1),
                    "content" to cursor.getString(2)
                )
            )

        main_listview_simple.adapter = SimpleAdapter(
            this, simpledatas
            , android.R.layout.simple_list_item_2
            , arrayOf("name", "content")
            , intArrayOf(android.R.id.text1, android.R.id.text2)
        )

        main_listview_cursor.adapter = SimpleCursorAdapter(
            this
            , android.R.layout.simple_list_item_2
            , cursor
            , arrayOf("name", "content")
            , intArrayOf(
                android.R.id.text1, android.R.id.text2
            )
        )

    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        Toast.makeText(this, arrayDatas[position], Toast.LENGTH_SHORT).show()
    }

}
