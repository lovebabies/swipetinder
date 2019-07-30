package com.example.swipeeffectdemo

import com.google.gson.annotations.SerializedName

data class Profile(@SerializedName("name") val name: String,
                   @SerializedName("url") val url: String,
                   @SerializedName("age") val age: Int,
                   @SerializedName("location") val location: String)