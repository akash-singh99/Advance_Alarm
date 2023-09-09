package com.akash.singh.alarmSettings.optionDeepWakeUp

import com.akash.singh.tools.BaseMediaContract


interface OptionSetDeepWakeUpContract {

    interface Presenter : BaseMediaContract {
        fun saveStateInSP(isChecked : Boolean)
        fun getStateFromSP() : Boolean
        fun getDeepWakeUpRingtoneName() : String
        fun start()
    }
}