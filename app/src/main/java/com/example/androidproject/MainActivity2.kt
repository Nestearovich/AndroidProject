package com.example.androidproject

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val textView2 = findViewById<TextView>(R.id.textView)

        val data: String = intent.getStringExtra(KEY) ?: getString(R.string.no_data)
        textView2.text = data

        val btnGoTo = findViewById<Button>(R.id.goToThird)
        btnGoTo.setOnClickListener {
            startActivity(
                Intent(this, MainActivity3::class.java)
            )
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
            R.id.close -> finishAffinity()
            R.id.goBack -> onBackPressed()

        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        private const val KEY = "1"

        fun startSecond(context: Context, string: String) {
            val intent = Intent(context, MainActivity2::class.java)
            intent.putExtra(KEY, string)
            context.startActivity(intent)
        }
    }
    }
