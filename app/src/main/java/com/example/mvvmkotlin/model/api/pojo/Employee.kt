package com.example.mvvmkotlin.model.api.pojo

import com.google.gson.annotations.SerializedName
import android.R
import android.widget.ImageView
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.Glide
import androidx.databinding.BindingAdapter



data class Employee(@SerializedName("avatar")
                    val avatar : String,
@SerializedName("email") val email : String,
@SerializedName("first_name") val firstName : String,
@SerializedName("id") val id : Long,
@SerializedName("last_name") val lastName : String){


    // important code for loading image here
    companion object {
        @JvmStatic
        @BindingAdapter("avatar")
        fun loadImage(imageView: ImageView, imageURL: String) {
            Glide.with(imageView.getContext())
                .setDefaultRequestOptions(
                    RequestOptions()
                        .circleCrop()
                )
                .load(imageURL)
//            .placeholder(R.drawable.loading)
                .into(imageView)
        }
    }
}