package com.android_basic.assignment4

import android.content.Context
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
class EmployeeCustomView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs,defStyleAttr) {

    private var image: ImageView
    private lateinit var textId: TextView
    private var textName: TextView
    private var checkBox: CheckBox

    init {
       LayoutInflater.from(context).inflate(R.layout.custom_employee_item,this,true)
        image = findViewById(R.id.image_Avatar)
        textName = findViewById(R.id.text_name)
        checkBox = findViewById(R.id.checkbox)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        val params = LayoutParams(
            LayoutParams.MATCH_PARENT,
            LayoutParams.WRAP_CONTENT
        )
        params.setMargins(10,10,10,10)
        setPadding(5,5,5,5)
    }

    fun bindData(employee: Employee){
        image.setImageResource(employee.avatar)
        textName.text = buildString {
            append("NV")
            append(employee.id)
            append(" - ")
            append(employee.name)
        }

        checkBox.isChecked = employee.isSelected

        checkBox.setOnCheckedChangeListener{ _, isSelected ->
            employee.isSelected = isSelected
        }
    }

}