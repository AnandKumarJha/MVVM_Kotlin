package com.example.mvvmkotlin.viewmodel

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmkotlin.model.StudentRepository
import com.example.mvvmkotlin.model.db.pojo.Student
import com.example.mvvmkotlin.model.db.pojo.User
import com.example.mvvmkotlin.model.db.pojo.User1
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {
    var student = Student(0,"", "", "Mahavir Enclave", "M")
    var user : User = User()
    var user1 : User1 = User1()
    var mStudentRepository = StudentRepository(application)

    suspend fun getAllStudents() : LiveData<List<Student>>{
        return mStudentRepository.getAllStudents()
    }

    suspend fun insertStudents(student: Student){
        mStudentRepository.insertStudent(student)
    }

    suspend fun deleteStudent(student: Student){
        mStudentRepository.deleteStudent(student)
    }
    fun showToast(){
        GlobalScope.launch {
            insertStudents(student)
        }

        user.userName = "anand"
        user.password = "hello"

        user1.userName.set("anand 1")
        user1.password.set("hello 1")
    }
}