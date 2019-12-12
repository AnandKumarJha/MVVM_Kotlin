package com.example.mvvmkotlin.model.api.service

import com.example.mvvmkotlin.model.api.pojo.EmployeeDBResponse
import retrofit2.Call
import retrofit2.http.GET


interface EmployeeDataService {
    @get:GET("users/?per_page=12&amp;page=1")
    val employees: Call<EmployeeDBResponse>
}