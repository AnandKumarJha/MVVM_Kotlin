package com.example.mvvmkotlin.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmkotlin.R
import com.example.mvvmkotlin.databinding.RowEmployeeBinding
import com.example.mvvmkotlin.model.api.pojo.Employee


class EmployeeAdapter(val employeeList: List<Employee>) :
    RecyclerView.Adapter<EmployeeAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val rowEmployeeBinding: RowEmployeeBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.row_employee, null, false)
        return MyViewHolder(rowEmployeeBinding)
    }

    override fun getItemCount(): Int {
        return employeeList.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.rowEmployeeBinding.employee = employeeList[position]
    }

    class MyViewHolder(val rowEmployeeBinding: RowEmployeeBinding) :
        RecyclerView.ViewHolder(rowEmployeeBinding.getRoot())
}