package com.example.alarmdemo

import android.app.IntentService
import android.content.Context
import android.content.Intent
import android.util.Log

@Suppress("DEPRECATION")
open class EventService : IntentService("EventService") {        // in Kotlin u cant extend more that 1 class
    companion object {
        const val NUM_E = "num"

        fun getStartIntent(context: Context, n: Int): Intent {
            val intent = Intent(context, EventService::class.java)
            intent.putExtra(NUM_E, n)
            return intent
        }
    }

    @Deprecated("Deprecated in Java", ReplaceWith(
        "Log.d(\"happySDK\", \"onHandleIntent \${intent?.getIntExtra(NUM_E, -1)}\")",
        "android.util.Log",
        "com.example.alarmdemo.EventService.Companion.NUM_E"
    )
    )
    override fun onHandleIntent(intent: Intent?) {
        Log.d("happySDK", "onHandleIntent ${intent?.getIntExtra(NUM_E, -1)}")
    }
}