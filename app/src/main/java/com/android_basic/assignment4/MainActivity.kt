package com.android_basic.assignment4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android_basic.assignment4.adapter.EmployeeAdapter
import com.android_basic.assignment4.databinding.ActivityMainBinding
import com.android_basic.assignment4.model.Employee

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var listEmployee: MutableList<Employee>
    private lateinit var adapter: EmployeeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {

        //init view
        listEmployee = mutableListOf()
        binding.recycleView.layoutManager = LinearLayoutManager(this)
        adapter = EmployeeAdapter(listEmployee)
        binding.recycleView.adapter = adapter

        //add employee
        binding.buttonAdd.setOnClickListener {
            //get insert user
            val id = binding.inputId.text.toString()
            val name = binding.inputName.text.toString()
            val avatar = if(binding.genderMale.isChecked){
                R.drawable.ic_man
            }else {
                R.drawable.ic_girl
            }
            //validate information
            if (id.isNotEmpty() && name.isNotEmpty()){
                val employee = Employee(id, avatar, name, false)
                listEmployee.add(employee)
                adapter.notifyDataSetChanged()
                Toast.makeText(this,"Add employee successfully!",Toast.LENGTH_SHORT).show()
            }else {
                Toast.makeText(this,"Please enter information!",Toast.LENGTH_SHORT).show()
            }

        }

        //remove employee selected
        binding.buttonRemove.setOnClickListener {
            adapter.removeCheckedItems()
        }
    }

}