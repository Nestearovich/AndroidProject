package com.example.androidproject.utils.rx

import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.ReplaySubject

class RxJavaExsample {

    fun observableJust1(){
        //1 способ
        val developer: io.reactivex.Observable<String> = io.reactivex.Observable.just(
            "IOS",
            "Android",
            "Flutter"
        )
        developer.doAfterNext{
            Log.w("next",it)
        }.doOnError{

        }.doOnComplete{
            Log.w("completed","finish")
        }.subscribe()

        //2 способ
        val developerAnotherWay : io.reactivex.Observable<String> = io.reactivex.Observable.just(
            "IOS",
            "Android",
            "Flutter"
        )
        developerAnotherWay.subscribe({
            Log.w("next",it)
        },{
            Log.w("campleted","finish")
        })
    }

    fun observableJust2(){
        //2 способ
        val developerAnotherWay : io.reactivex.Observable<String> = io.reactivex.Observable.just(
            "IOS",
            "Android",
            "Flutter"
        )
        developerAnotherWay.subscribe({
            Log.w("next",it)
        },{
            Log.w("campleted","finish")
        })
    }
    fun observableFlatmap(){
        io.reactivex.Observable.just("IOS","Android","Flutter")
            .subscribeOn(Schedulers.io())
            .flatMap {
                io.reactivex.Observable.just("$it 2")
                    .subscribeOn(Schedulers.io())
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{
                Log.w("result",it.toString())
            }
    }
    fun observableZip(){
        io.reactivex.Observable.zip(
            io.reactivex.Observable.just("IOS","Android","Flutter"),
            io.reactivex.Observable.just("Swift","Kotlin","Dart")
        ){dev, lang ->
            Log.w("result zip","$dev writes in $lang")
        }.subscribe({Log.w("result zip",it.toString())})
    }
    fun observableConcat(){
        val devs =  io.reactivex.Observable.just("IOS","Android","Flutter")
        val langs = io.reactivex.Observable.just("Swift","Kotlin","Dart")
        val comp = io.reactivex.Observable.just("Apple","Google")

        io.reactivex.Observable.concat(devs,langs,comp)
            .subscribe({Log.w("result concat",it.toString())})
    }
    fun observableCreate(){
        val devList = listOf<String>("IOS","Android","Flutter")

        io.reactivex.Observable.create<String>{ emitter ->
            devList.forEach{ deloveper ->
                if (deloveper.isEmpty()){
                    emitter.onError(Exception("value is empty"))
                }
                emitter.onNext(deloveper)
            }
        }.doAfterNext{
            Log.w("next",it)
        }.doOnError(){

        }.doOnComplete{
            Log.w("complete from create","finish")
        }.subscribe({},{Log.w("error",it.message.toString())})
    }
    fun publishSubject(){
        val publishSubject = PublishSubject.create<Int>()
        publishSubject.onNext(1)
        publishSubject.onNext(2)
        publishSubject.onNext(3)
        publishSubject.subscribe({Log.w("publish value",it.toString())})
        publishSubject.onNext(4)
        publishSubject.onNext(5)
        publishSubject.subscribe({Log.w("publish value2",it.toString())})
    }
    fun replaySubject(){
        val publishSubject2 = ReplaySubject.create<Int>()
        publishSubject2.onNext(1)
        publishSubject2.onNext(2)
        publishSubject2.onNext(3)
        publishSubject2.subscribe({Log.w("publish value",it.toString())})
        publishSubject2.onNext(4)
        publishSubject2.onNext(5)
        publishSubject2.subscribe({Log.w("publish value2",it.toString())})
    }
}