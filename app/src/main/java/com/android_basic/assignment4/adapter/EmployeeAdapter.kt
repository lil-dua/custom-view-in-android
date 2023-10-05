package com.android_basic.assignment4.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android_basic.assignment4.EmployeeCustomView
import com.android_basic.assignment4.model.Employee

/***
 * Created by HoangRyan aka LilDua on 10/4/2023.
 */
class EmployeeAdapter (
    private val employeeList: MutableList<Employee>
) : RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder>(){

    class EmployeeViewHolder(val customView: EmployeeCustomView) : RecyclerView.ViewHolder(customView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val customView = EmployeeCustomView(parent.context)
        return EmployeeViewHolder(customView)
    }

    override fun getItemCount(): Int {
        return employeeList.size
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        val employee = employeeList[position]
        holder.customView.bindData(employee)
    }

    fun removeCheckedItems() {
        employeeList.removeAll { it.isSelected}
        notifyDataSetChanged()
    }
}