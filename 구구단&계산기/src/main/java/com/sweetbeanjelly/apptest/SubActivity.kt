package com.sweetbeanjelly.apptest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sub.*

class SubActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        val name = intent.getStringExtra("Name").toString()
        val age = intent.getStringExtra("Age").toString()

        txt1.text = "Name : "+name
        txt2.text = "Age : "+age
    }
}
