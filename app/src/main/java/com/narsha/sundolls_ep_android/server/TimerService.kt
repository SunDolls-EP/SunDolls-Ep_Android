package com.narsha.sundolls_ep_android.server

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class TimerService : Service() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("서비스","시작")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }
}