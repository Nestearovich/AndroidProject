package com.example.androidproject.utils.coroutines

import android.util.Log
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CoroutinesEx {

    fun testCoroutinesJoin(){
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
    fun testCoroutinesCancek(){
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