package com.example.mvvmkotlin.model

import androidx.lifecycle.MutableLiveData
import java.util.ArrayList

import com.example.mvvmkotlin.model.api.RetrofitClient
import com.example.mvvmkotlin.model.api.pojo.Employee
import com.example.mvvmkotlin.model.api.pojo.EmployeeDBResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EmployeeRepository {
    private var employees = ArrayList<Employee>()
    private val mutableLiveData = MutableLiveData<List<Employee>>()

    fun getMutableLiveData(): MutableLiveData<List<Employee>> {

        val userDataService = RetrofitClient.service

        val call = userDataService.employees
        call.enqueue(object : Callback<EmployeeDBResponse> {
            override fun onResponse(call: Call<EmployeeDBResponse>, response: Response<EmployeeDBResponse>) {
                val employeeDBResponse = response.body()
                if (employeeDBResponse != null && employeeDBResponse.employee != null) {
                    employees = employeeDBResponse.employee as ArrayList<Employee>
                    mutableLiveData.value = employees
                }
            }

            override fun onFailure(call: Call<EmployeeDBResponse>, t: Throwable) {}
        })

        return mutableLiveData
    }

    companion object {
        private val TAG = "EmployeeRepository"
    }
}
