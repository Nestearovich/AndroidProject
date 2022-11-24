package com.example.androidproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        val btn = findViewById<Button>(R.id.btn_1)
        btn.setOnClickListener {

            val listView = findViewById<ListView>(R.id.list_item)

            val list = listOf<String>(
                "apple",
                "Banana",
                "Kiwi",

            )

            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,list)
            listView.adapter = adapter
        }
    }
}