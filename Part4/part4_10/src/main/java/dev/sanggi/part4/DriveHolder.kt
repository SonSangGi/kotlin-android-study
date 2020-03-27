package dev.sanggi.part4

import android.view.View
import android.widget.ImageView
import android.widget.TextView

class DriveHolder {

    lateinit var typeImageView: ImageView
    lateinit var titleView: TextView
    lateinit var dateView: TextView
    lateinit var menuImageView: ImageView

    constructor(root: View?) {
        typeImageView = root!!.findViewById(R.id.custom_item_type_image)
        titleView = root!!.findViewById(R.id.custom_item_title)
        dateView = root!!.findViewById(R.id.custom_item_date)
        menuImageView = root!!.findViewById(R.id.custom_item_menu)
    }
}