package com.example.mvvmkotlin.view.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmkotlin.R
import com.example.mvvmkotlin.databinding.ActivityMainBinding
import com.example.mvvmkotlin.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_db.setOnClickListener {
            startActivity(Intent(this, DbActivity::class.java))
        }

        btn_retrofit.setOnClickListener {
            startActivity(Intent(this, RetrofitTestActivity::class.java))
        }
    }
}
