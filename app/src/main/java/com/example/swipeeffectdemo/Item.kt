package com.example.swipeeffectdemo

import com.google.gson.annotations.SerializedName

data class Item(@SerializedName("id") val id: String,
                @SerializedName("thumbnail") val thumbnail: String,
                @SerializedName("price") val price: String,
                @SerializedName("description") val description: String,
                @SerializedName("name") val name: String)