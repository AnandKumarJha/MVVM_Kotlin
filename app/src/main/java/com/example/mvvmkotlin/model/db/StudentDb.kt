package com.example.mvvmkotlin.model.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mvvmkotlin.model.db.dao.StudentDao
import com.example.mvvmkotlin.model.db.pojo.Student

@Database(entities = arrayOf(Student::class), version = 3)
abstract class StudentDb : RoomDatabase() {
    abstract fun studentDao(): StudentDao
}
