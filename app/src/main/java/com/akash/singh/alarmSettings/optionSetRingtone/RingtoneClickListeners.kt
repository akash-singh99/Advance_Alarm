package com.akash.singh.alarmSettings.optionSetRingtone

import android.view.View
import android.widget.CheckBox
import android.widget.ImageButton


interface RingtoneClickListeners {
    fun imageButtonClickListener(view: ImageButton, position: Int)
    fun checkBoxClickListener(view: CheckBox, position: Int)
    fun recycleViewClickListener(view: View, position: Int)

}