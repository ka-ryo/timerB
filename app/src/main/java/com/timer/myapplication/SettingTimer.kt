package com.timer.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_setting_timer.*
import org.jetbrains.anko.startActivity

class SettingTimer : AppCompatActivity() {
    private lateinit var realm :Realm
    private var sound:Boolean=true
    private var repeat:Boolean=true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting_timer)

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
