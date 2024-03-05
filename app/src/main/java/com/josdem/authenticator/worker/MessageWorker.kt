package com.josdem.authenticator.worker

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.time.LocalDateTime

class MessageWorker(context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {
    override fun doWork(): Result {
        getMessage()
        return Result.success()
    }

    private fun getMessage() {
        Log.d("worker message:", LocalDateTime.now().toString())
    }
}
