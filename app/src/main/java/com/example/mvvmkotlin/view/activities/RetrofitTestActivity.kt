package com.example.mvvmkotlin.view.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmkotlin.R
import com.example.mvvmkotlin.databinding.ActivityMainBinding
import com.example.mvvmkotlin.databinding.ActivityRetrofitTestBinding
import com.example.mvvmkotlin.model.api.pojo.Employee
import com.example.mvvmkotlin.view.adapter.EmployeeAdapter
import com.example.mvvmkotlin.viewmodel.EmployeeViewModel
import java.util.ArrayList

class RetrofitTestActivity : AppCompatActivity() {
    private var employeeViewModel: EmployeeViewModel? = null
    private var employeeDataAdapter: EmployeeAdapter? = null
    private var employeeList: ArrayList<Employee> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityRetrofitTestActivity: ActivityRetrofitTestBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_retrofit_test)

        // bind RecyclerView
        val recyclerView = activityRetrofitTestActivity.viewEmployees
        recyclerView.setLayoutManager(LinearLayoutManager(this))
        recyclerView.setHasFixedSize(true)

        employeeViewModel = ViewModelProviders.of(this).get(EmployeeViewModel::class.java)
        employeeDataAdapter = EmployeeAdapter(employeeList)
        recyclerView.setAdapter(employeeDataAdapter)
        getAllEmployee()
    }

    private fun getAllEmployee() {
        employeeViewModel?.allEmployee?.observe(this, Observer { employees ->
            employees.run {
                employeeList.addAll(employees)
                employeeDataAdapter?.notifyDataSetChanged()
            }
        })
    }
}