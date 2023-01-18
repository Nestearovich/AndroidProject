package com.example.androidproject.utils.coroutines

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CoroutinesExample {

//    fun testCoroutinesJoin(){
//        CoroutineScope(Dispatchers.IO).launch {
//            val job = launch {
//                for (i in 1..5){
//                    Log.w("called","$i")
//                    delay(400)
//                }
//            }
//            Log.w("start","started")
//            Log.w("finish","finished")
//        }
//    }
    fun testCoroutinesCancel(){
        CoroutineScope(Dispatchers.IO).launch {
            val job = launch {
                for (i in 1..5){
                    Log.w("called","$i")
                    delay(400)
                }
            }
            Log.w("start","started")
            Log.w("finish","finished")
        }
    }
}