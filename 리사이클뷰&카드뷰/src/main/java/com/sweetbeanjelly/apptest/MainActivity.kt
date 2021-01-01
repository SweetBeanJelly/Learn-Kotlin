package com.sweetbeanjelly.apptest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private var memos = ArrayList<Memo>();
    private var llm = LinearLayoutManager(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_view.setHasFixedSize(true)
        recycler_view.layoutManager = llm

        btn.setOnClickListener {
            var title : String = main_title.text.toString()
            var content : String = main_content.text.toString()

            var sdf = SimpleDateFormat("HH:mm aa")
            var currentTime : String = sdf.format(Date(System.currentTimeMillis()))

            var memo = Memo(title, content, currentTime)
            memos.add(memo)

            recycler_view.adapter = CustomAdapter(applicationContext, memos)

            main_title.setText("")
            main_content.setText("")
        }

    }
}




