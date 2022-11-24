package com.example.androidproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.androidproject.KotlinActivity.Companion.kotlinActivityStart
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val editText = findViewById<EditText>(R.id.et_text)
        val editText2 = findViewById<EditText>(R.id.et_text2)

        val button = findViewById<Button>(R.id.btn_displayText)
        val textView = findViewById<TextView>(R.id.tv_text)

        val layout1 = findViewById<TextInputEditText>(R.id.textInputLayout)
        val layout2 = findViewById<TextInputLayout>(R.id.til)



        val dialog = AlertDialog.Builder(this)
            .setTitle("Information")
            .setMessage("i am Android Developer")
            .setCancelable(false)
            .setPositiveButton("Ok"){dialog, _ ->
                Toast.makeText(this,"called positiv",Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("cancel"){dialog, _ ->
                dialog.cancel()
            }

        button.setOnClickListener{
            dialog.show()
            if(editText.text.toString().isEmpty()){

                editText.error =  "name cant be empty"

            }else if (editText2.text.toString().isEmpty()){

                editText2.error ="password can't be empty"

            }else{

                kotlinActivityStart(this)
                textView.text = "${editText.text.toString()} ${editText2.toString()}"
            }
          //  textView.text= " ${editText.text.toString()} ${editText2.text.toString()}"
        }

    }
}