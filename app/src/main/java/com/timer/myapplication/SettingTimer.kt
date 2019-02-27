package com.timer.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_setting_timer.*
import org.jetbrains.anko.startActivity
import io.realm.RealmConfiguration
import io.realm.kotlin.createObject
import io.realm.kotlin.where


class SettingTimer : AppCompatActivity() {
    private lateinit var realm :Realm
    private var sound:Boolean=true
    private var repeat:Boolean=true



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting_timer)
        realm= Realm.getDefaultInstance()

        repeatButton.setOnClickListener {
            repeat=!repeat
        }

        soundButton.setOnClickListener {
            when(sound){
                true->{
                    soundButton.setImageResource(R.drawable.ic_volume_off_black_24dp)
                }
                false->{
                    soundButton.setImageResource(R.drawable.ic_volume_up_black_24dp)
                }
            }
            sound=!sound
        }

        repeatButton.setOnClickListener {
            when(repeat){
                true->{
                    repeatComfig.visibility=View.VISIBLE
                }
                false->{
                    repeatComfig.visibility=View.INVISIBLE
                }
            }
            repeat=!repeat
        }

        saveButton.setOnClickListener {
            realm.executeTransaction {
                val maxId=realm.where<TimerdbModel>().max("id")
                val nextId = (maxId?.toLong() ?: 0L)+1
                val timer = realm.createObject<TimerdbModel>(nextId)

                //データの登録//
                timer.minute=editMinute.text.toString().toLong()
                timer.second=editSecond.text.toString().toLong()
                timer.repeatBoolean=repeat
                timer.soundBoolean=sound

                when(editTitle.text.toString()==""){
                    true ->{
                        timer.title="タイマー"
                    }
                    else ->{
                        timer.title=editTitle.text.toString()
                    }
                }

                when(editMinute.text.toString().toLong()){
                    0L ->{
                      timer.stringMinute="00"
                    }
                    else ->{
                        timer.stringMinute=editMinute.text.toString()
                    }
                }

                when(editSecond.text.toString().toLong()){
                    0L ->{
                        timer.stringSecond="00"
                    }
                    else ->{
                        timer.stringSecond=editSecond.text.toString()
                    }
                }


                Log.d("MainActivity","aaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
            }
            startActivity<MainActivity>()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.settingmenu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.backButton->{
                startActivity<MainActivity>()
            }
        }

        return super.onOptionsItemSelected(item)
    }


}
