package com.example.androidproject

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.androidproject.MainActivity2.Companion.startSecond

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.black)))
        supportActionBar?.title ="New title for MainActivity"


        setContentView(R.layout.activity_main)
        val btnGoTo = findViewById<Button>(R.id.goToSecond)
        val btnClick = findViewById<Button>(R.id.clickMe)
        val textView = findViewById<TextView>(R.id.valhalla)

        btnClick.setOnClickListener{
            textView.text = getString(R.string.hello)
            startSecond(this,
                textView.text.toString()+getString(R.string.fromMain))
        }
        btnGoTo.setOnClickListener{
            startActivity(
                Intent(this,MainActivity2::class.java)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

//                    .addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
            )
            val btnClick = findViewById<Button>(R.id.clickMe)
            val textView = findViewById<TextView>(R.id.valhalla)

            btnClick.setOnClickListener{
                val intent = Intent(this,MainActivity2::class.java)
                startActivity(intent)

                textView.text = "Hello world"//intent extra
            }
        }
    }
    }
