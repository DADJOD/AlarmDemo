@file:Suppress("DEPRECATION")

package com.example.alarmdemo

import android.annotation.SuppressLint
import android.app.IntentService
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

open class EventService : IntentService("EventService") {        // in Kotlin u cant extend more that 1 class
    companion object {
        const val NUM_E = "num"

        fun getStartIntent(context: Context, n: Int): Intent {
            val intent = Intent(context, EventService::class.java)
            intent.putExtra(NUM_E, n)
            return intent
        }
    }

    @SuppressLint("MissingPermission")
    override fun onHandleIntent(intent: Intent?) {
        val num = intent?.getIntExtra(NUM_E, -1)
        Log.d("happySDK", "$NUM_E $num")

        val ua = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 2, ua, PendingIntent.FLAG_UPDATE_CURRENT)

        val builder = NotificationCompat.Builder(this)
            .setSmallIcon(android.R.drawable.ic_dialog_map)
            .setContentTitle("Hello!")
            .setContentText("got $num")
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)

        NotificationManagerCompat.from(this).notify(1, builder.build())
    }
}