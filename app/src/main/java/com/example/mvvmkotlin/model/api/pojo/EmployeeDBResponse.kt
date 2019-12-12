package com.example.mvvmkotlin.model.api.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class EmployeeDBResponse(
    @SerializedName("page") @Expose val page: Int,
    @SerializedName("per_page") @Expose val perPage: Int,
    @SerializedName("total") @Expose val total: Int,
    @SerializedName("total_pages") @Expose val totalPages: Int,
    @SerializedName("data") @Expose val employee: List<Employee>
)