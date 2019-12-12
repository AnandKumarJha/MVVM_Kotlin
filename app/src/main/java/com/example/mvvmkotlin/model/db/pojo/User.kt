package com.example.mvvmkotlin.model.db.pojo

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.mvvmkotlin.BR

 class User : BaseObservable(){

    @get:Bindable
    var userName : String = ""
    set(value) {
        field = value
        notifyPropertyChanged(BR.userName)
    }

    @get:Bindable
    var password : String = ""
    set(value) {
        field = value
        notifyPropertyChanged(BR.password)
    }
}