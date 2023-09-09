package com.akash.singh.alarms.mathAlarm.mainAlarm

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import com.akash.singh.data.AlarmDataHelper
import com.akash.singh.tools.AlarmTools
import java.util.*
import javax.inject.Inject

class MainAlarmViewModel @Inject constructor(private val dataHelper: AlarmDataHelper) : ViewModel() {
    private val TAG = this.javaClass.simpleName
    private val calendar = Calendar.getInstance()
    private val time = dataHelper.getTimeFromSP()

    val alarmTime = ObservableField<String>()
    val isDarkTime = ObservableBoolean()

    val alarmRingtone = dataHelper.getRingtoneFromSP()
    val alarmMessage = "\"" + dataHelper.getTextMessageFromSP() + "\""
    val alarmDeepWakeUp = dataHelper.getDeepWakeUpStateFromSP()

    init {
        start()
    }

    private fun start() {
        alarmTime.set(AlarmTools.getReadableTime(time.first, time.second))
        calendar.timeInMillis = System.currentTimeMillis()
        setDayOrNight()
    }

    private fun setDayOrNight() {
        isDarkTime.set(calendar.get(Calendar.HOUR_OF_DAY) !in 6 until 20)

    }

    fun getCurrentDayOfWeek(): Int {
        return calendar.get(Calendar.DAY_OF_WEEK) - 1

    }

    fun isFirstAlarmCreation() = dataHelper.isFirstAlarmSaving()

    fun getAlarmDataObject() = dataHelper.getAlarmDataObject()
}