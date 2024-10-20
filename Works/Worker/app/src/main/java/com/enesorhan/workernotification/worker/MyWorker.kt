package com.enesorhan.workernotification.worker

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWorker(appContext: Context,workerParameters: WorkerParameters) : Worker(appContext,workerParameters) {
    override fun doWork(): Result {
        val name = "Enes"
        Log.e("Coder Name -> ",name)
        return Result.success()
    }
}