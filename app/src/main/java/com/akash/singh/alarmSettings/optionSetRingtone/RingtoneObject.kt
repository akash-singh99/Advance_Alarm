package com.akash.singh.alarmSettings.optionSetRingtone


import android.net.Uri

 class RingtoneObject(
        val name: String,
        var rating: Int = 0,
        var isPlaying: Boolean = false,
        var isChecked: Boolean = false,
        val uri: Uri? = null)