package com.example.mvvmkotlin.model.db.pojo

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.ObservableField
import com.example.mvvmkotlin.BR

class User1 : BaseObservable() {

    var userName = ObservableField<String>()
    var password = ObservableField<String>()
}