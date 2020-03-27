package dev.sanggi.part4

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import org.w3c.dom.Text

open class DriverAdapter(
    context: Context,
    private val resId: Int,
    private var datas: ArrayList<DriveVO>
) :
    ArrayAdapter<DriveVO>(context, resId, datas) {

    override fun getCount(): Int {
        return datas.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var view: View

        if (convertView == null) {
            val inflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(resId, null)
            view.tag = DriveHolder(view)
        }else {
            view = convertView
        }

        val holder = view.tag as DriveHolder

        // 항목 layout 초기화

        //View 획득
        val typeImageView = holder.typeImageView
        val titleView = holder.titleView
        val dateView = holder.dateView
        val menuImageView = holder.menuImageView

        // 항목 데이터 획득
        val vo = datas.get(position)

        //View에 데이터 설정
        titleView.text = vo.title
        dateView.text = vo.date

        // 개발자 알고리즘으로 데이터 설정
        val typeDrawable: Int = when (vo.type) {
            "doc" -> R.drawable.ic_type_doc
            "file" -> R.drawable.ic_type_file
            "img" -> R.drawable.ic_type_image
            else -> -1
        }

        typeImageView.setImageDrawable(
            ResourcesCompat.getDrawable(
                context.resources,
                typeDrawable,
                null
            )
        )

        // View에 이벤트 연결
        menuImageView.setOnClickListener {
            Toast.makeText(context, "${vo.title} menu click", Toast.LENGTH_SHORT).show()
        }

        return view
    }
}