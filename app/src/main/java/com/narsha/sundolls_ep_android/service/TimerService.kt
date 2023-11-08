package com.narsha.sundolls_ep_android.service

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import com.narsha.sundolls_ep_android.ui.activity.HomeActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class TimerService : Service() {

    private var isRunning = false
    private var job: Job? = null
    private var secondsPassed = 0
    private val notificationId = 1


    override fun onCreate() {
        super.onCreate()
        Log.d("서비스","onCreate()")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("서비스","onStartCommand()")
        val notification = createNotification()
        startForeground(notificationId, notification)
        when (intent?.action) {
            "start" -> startTimer()
            "stop" -> stopTimer()
            else -> Log.d("서비스",intent?.action.toString())
        }
        return START_STICKY
    }

    private fun startTimer() {
        if (!isRunning) {
            isRunning = true
            job = CoroutineScope(Dispatchers.Default).launch {
                Log.d("타이머",secondsPassed.toString())
                while (isRunning) {
                    delay(1000)
                    secondsPassed++
                    updateNotification()
                }
            }
        }
    }

    private fun stopTimer() {
        isRunning = false
        job?.cancel()
        updateNotification()
    }

    private fun updateNotification() {
        val intent = Intent(this, TimerService::class.java).apply {
            action = "stop"
        }
        val pendingIntent = PendingIntent.getService(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)

        val notification = Notification.Builder(this, "my_service")
            .setContentTitle("Foreground Timer")
            .setContentText("Timer: $secondsPassed seconds")
            .setContentIntent(pendingIntent)
            .setOngoing(true)
            .build()


        val notificationManager = getSystemService(NotificationManager::class.java)
        notificationManager.notify(notificationId, notification)
    }

    override fun onRebind(intent: Intent?) {
        super.onRebind(intent)
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    private fun createNotification(): Notification {
        val channelId =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                createNotificationChannel("my_service", "My Background Service")
            } else {
                ""
            }

        val notificationIntent = Intent(this, HomeActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
            this, 0, notificationIntent, PendingIntent.FLAG_IMMUTABLE
        )

        return NotificationCompat.Builder(this, channelId)
            .setContentTitle("Foreground Timer")
            .setContentText("Timer: $secondsPassed seconds")
            .setContentIntent(pendingIntent)
            .setOngoing(true)
            .build()
    }

    private fun createNotificationChannel(channelId: String, channelName: String): String {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT)
            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
            return channelId
        }
        return ""
    }

}