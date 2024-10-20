package com.enesorhan.workernotification.worker

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build.VERSION
import android.os.Build.VERSION_CODES
import androidx.core.app.NotificationCompat
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.enesorhan.workernotification.MainActivity
import com.enesorhan.workernotification.R

class NotificationWorker(appContext: Context, workerParameters: WorkerParameters) : Worker(appContext,workerParameters) {
    override fun doWork(): Result {
        createNotification()
        return Result.success()
    }

    private fun createNotification() {
        val notification : NotificationCompat.Builder
        val notificationManager = applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val intent = Intent(applicationContext,MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(applicationContext,1,intent,PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT)

        if(VERSION.SDK_INT >= VERSION_CODES.O){

            val channelId = "WorkerApp"
            val channelName = "Run 'app'"
            val channelDesc = "Click for open WorkerApp"
            val channelPriority = NotificationManager.IMPORTANCE_HIGH

            var channel:NotificationChannel? = notificationManager.getNotificationChannel(channelId)

            if(channel==null){
                channel = NotificationChannel(channelId,channelName,channelPriority)
                channel.description = channelDesc
                notificationManager.createNotificationChannel(channel)
            }

            notification = NotificationCompat.Builder(applicationContext,channelId)
                .setContentTitle("WorkerApp")
                .setContentText("Run 'app'")
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .setSmallIcon(R.drawable.baseline_rocket_launch_24)
        }else{
            notification = NotificationCompat.Builder(applicationContext)
                .setContentTitle("WorkerApp")
                .setContentText("Run 'app'")
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .setSmallIcon(R.drawable.baseline_rocket_launch_24)
                .setPriority(NotificationManager.IMPORTANCE_HIGH)
        }
        notificationManager.notify(1,notification.build())
    }
}