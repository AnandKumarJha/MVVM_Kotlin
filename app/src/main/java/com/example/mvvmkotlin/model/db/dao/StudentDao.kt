package com.example.mvvmkotlin.model.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.mvvmkotlin.model.db.pojo.Student

@Dao
interface StudentDao {
    @Query("Select * from Student")
    fun getStudents() : LiveData<List<Student>>

    @Insert
    fun insertStudent(student : Student)

    @Insert
    fun insertMultipleStudent(vararg student: Student)

    @Delete
    fun deleteStudent(student: Student)

    @Query("Delete from Student")
    fun deleteAllStudent()

}