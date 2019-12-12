package com.example.mvvmkotlin.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmkotlin.R
import com.example.mvvmkotlin.databinding.ActivityMainBinding
import com.example.mvvmkotlin.viewmodel.UserViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DbActivity : AppCompatActivity() {

    private lateinit var userViewModel : UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_db)

        val binding : ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        userViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
        binding.userViewModel = userViewModel

        GlobalScope.launch(Dispatchers.Main) {
            userViewModel.getAllStudents().observe(this@DbActivity, Observer {
                Log.e("TAG", it.toString())
            })
        }
    }
}
