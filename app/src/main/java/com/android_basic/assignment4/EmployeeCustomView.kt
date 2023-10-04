package com.android_basic.assignment4

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.android_basic.assignment4.model.Employee

/***
 * Created by HoangRyan aka LilDua on 10/4/2023.
 */
class EmployeeCustomView(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

    private lateinit var name: String
    private var id: Int = 0

    lateinit var image: ImageView
    lateinit var textId: TextView
    lateinit var textName: TextView
    lateinit var checkBox: CheckBox

    init {
        context.theme.obtainStyledAttributes(attrs,R.styleable.EmployeeCustomView,0,0)
            .apply {
                id = getString(R.styleable.EmployeeCustomView_id)?.toInt() ?: return@apply
                name = getString(R.styleable.EmployeeCustomView_name).toString()
            }
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        initView()
    }


    private fun initView() {
        orientation = HORIZONTAL
        image = ImageView(context)
        textId = TextView(context)
        textName = TextView(context)
        checkBox = CheckBox(context)

        image.setImageResource(R.drawable.ic_man)
        textId.text = id.toString()
        textName.text = name
        checkBox.isChecked = false

        addView(image)
        addView(textId)
        addView(textName)
        addView(checkBox)
    }
}