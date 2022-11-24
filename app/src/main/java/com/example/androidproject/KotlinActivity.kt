package com.example.androidproject

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast

class KotlinActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)

        makeRequest("https://google.com"){callBackResualt ->
            Log.w("callBack result",callBackResualt)
        }


        val btn = findViewById<Button>(R.id.K_btn)
        val person = object {//анонимный класс
            val name = "Alex"
            fun develop(){
                Log.w("anonym class","called develop fun")
            }
        }
        val person2 = object:Developer {
            val name = "Alex"
            override fun develop() {
                Log.w("anonym class","called develop fun")
            }
        }

        val house = HauseBilder
            .setStock(3)
            .setSwimpool(false)
            .build()

        btn.setOnClickListener {
            Log.w("housbuilder","${house.hasSwimpool()} ${house.howManyStocks()}")
            person.develop()
            person2.name
            person2.develop()
            callAnonymClass(person2)
            Toast.makeText(this,person.name,Toast.LENGTH_SHORT).show()

        }


        val lambda = { string: String ->
            Toast.makeText(
                this, "your test is $string",
                Toast.LENGTH_SHORT
            ).show()
        }//это лямбда
        lambda("Set nest in lambda")
    }

//    fun get():String{//возращаемая функция
//        return  ""
//    }
//    fun get2()= ""


   private fun returnAnonymClass(string: String)= object{
        fun develop(){
            Log.w("anonym class","called develop fun from returnType $string")
        }
    }

    fun callAnonymClass(developer: Developer){
        developer.develop()
    }

    fun makeRequest(url:String,argForCallback: (string:String)->Unit){
        argForCallback.invoke("result from $url")
    }

    companion object {

        fun kotlinActivityStart(context: Context) {
            context.startActivity(Intent(context, KotlinActivity::class.java))
        }
    }
}


interface Developer{
    fun develop()
}
