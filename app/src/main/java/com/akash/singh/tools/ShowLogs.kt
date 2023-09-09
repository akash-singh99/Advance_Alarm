package com.akash.singh.tools

import android.util.Log

object ShowLogs {
    private var isDebugging = ConstantValues.LOG_DEBUG_STATUS

    fun log(TAG: String, logMessage: String) {
        if (isDebugging)
            Log.i("KOKO " + TAG, " " + logMessage)
    }

}