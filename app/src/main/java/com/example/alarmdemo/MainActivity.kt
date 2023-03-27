package com.example.alarmdemo

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import java.util.concurrent.TimeUnit

@Suppress("UNUSED_PARAMETER")
class MainActivity : AppCompatActivity() {
    private lateinit var am: AlarmManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    @SuppressLint("UnspecifiedImmutableFlag")
    fun buttonClick(view: View) {
        am = getSystemService(ALARM_SERVICE) as AlarmManager

        // startService(intent)

        val intent = EventService.getStartIntent(this@MainActivity, 123)
        val pendingIntent = PendingIntent.getService(this@MainActivity, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        val targetTime = System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(5)

        am.set(AlarmManager.RTC, targetTime, pendingIntent)
    }
}