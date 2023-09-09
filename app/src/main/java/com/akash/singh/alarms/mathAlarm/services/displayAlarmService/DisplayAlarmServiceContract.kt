package com.akash.singh.alarms.mathAlarm.services.displayAlarmService

import com.akash.singh.tools.BaseMediaContract

interface DisplayAlarmServiceContract {
    interface Presenter : BaseMediaContract {
        fun playDeepWakeUpRingtone()
        fun getDeepWakeUpState() : Boolean
        fun start()
    }
}