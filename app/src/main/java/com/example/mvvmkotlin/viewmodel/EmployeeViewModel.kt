package com.example.mvvmkotlin.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.mvvmkotlin.model.EmployeeRepository
import com.example.mvvmkotlin.model.api.pojo.Employee

class EmployeeViewModel(application: Application) : AndroidViewModel(application) {
    private val employeeRepository: EmployeeRepository

    val allEmployee: LiveData<List<Employee>>
        get() = employeeRepository.getMutableLiveData()

    init {
        employeeRepository = EmployeeRepository()
    }
}