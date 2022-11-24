package com.example.androidproject

import androidx.appcompat.app.AlertDialog.Builder

class HauseBilder(val builder:Builder) {

    fun hasSwimpool() = builder.swimpool

    fun howManyStocks() = builder.stock

    companion object{
        var stock: Int = 0
        var swimpool: Boolean = false


        fun setStock(stock:Int) = apply { this.stock=stock }
        fun setSwimpool(swimpool:Boolean) = apply {this.swimpool = swimpool}
        fun build():HausBilder{
            return HauseBilder(this)
        }
    }
}