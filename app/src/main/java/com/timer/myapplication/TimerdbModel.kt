package com.timer.myapplication

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class TimerdbModel:RealmObject() {
    @PrimaryKey
    var id:Long =0
    var title:String ="タイマー"
    var timer:Long=0
   // var repeat_boolean:Boolean=true
    //var sound_boolean:Boolean=true

}