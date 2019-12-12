package com.example.mvvmkotlin.model.db.pojo

import androidx.databinding.BaseObservable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Student (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "RollNumber") var rollNumber: Int,
    @ColumnInfo(name = "Name", defaultValue = "") var name: String,
    @ColumnInfo(name = "Password", defaultValue = "") var password: String,
    @ColumnInfo(name = "Address") var address: String,
    @ColumnInfo(name="Sex") var sex : String
)