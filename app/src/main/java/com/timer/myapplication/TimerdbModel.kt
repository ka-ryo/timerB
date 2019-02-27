package com.timer.myapplication

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class TimerdbModel:RealmObject() {

    @PrimaryKey
    var id:Long =0
    var title:String =""
    var timer:Long=0
    var minute:Long=0
    var second:Long=0
    var stringMinute:String =""
    var stringSecond:String=""
    var repeatBoolean:Boolean=true
    var soundBoolean:Boolean=true

}