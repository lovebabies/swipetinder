package com.example.swipeeffectdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    private val URL_API = "https://api.androidhive.info/json/menu.json"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        setSupportActionBar(toolbar)
        supportActionBar?.title = "EDMT card"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}
