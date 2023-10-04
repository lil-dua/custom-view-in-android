package com.android_basic.assignment4.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android_basic.assignment4.R
import com.android_basic.assignment4.model.Employee

/***
 * Created by HoangRyan aka LilDua on 10/4/2023.
 */
class EmployeeAdapter (
    private val employeeList: MutableList<Employee>
) :
    RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder>(){

    inner class EmployeeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.text_name)
        val image: ImageView = itemView.findViewById(R.id.image_Avatar)
        val checkBox: CheckBox = itemView.findViewById(R.id.checkbox)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.custom_employee_item,parent,false)
        return EmployeeViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return employeeList.size
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        val employee = employeeList[position]
        holder.name.text = buildString {
            append("NV")
            append(employee.id)
            append(" - ")
            append(employee.name)
        }

        holder.image.setImageResource(employee.avatar)
        holder.checkBox.isChecked = employee.isSelected

        holder.checkBox.setOnCheckedChangeListener{ _, isSelected ->
            employee.isSelected = isSelected
        }
    }

    fun removeCheckedItems() {
        employeeList.removeAll { it.isSelected}
        notifyDataSetChanged()
    }
}