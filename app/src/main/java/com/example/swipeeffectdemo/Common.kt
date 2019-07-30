package com.example.swipeeffectdemo

object Common {
    @JvmStatic
    fun getMenuRequest(): IMenuRequest {
        return RetrofitClient.getClient("https://api.androidhive.info/").create(IMenuRequest::class.java)
    }
}