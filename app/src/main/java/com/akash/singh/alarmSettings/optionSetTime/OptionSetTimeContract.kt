package com.akash.singh.alarmSettings.optionSetTime

import com.akash.singh.Interfaces.BasePresenter
import com.akash.singh.Interfaces.BaseView

interface OptionSetTimeContract {
    interface View : BaseView<Presenter> {
        fun initializeTimePicker(hourOfDay: Int, minutes: Int)
        fun showTimeUntilAlarmBoom(hourOfDay: Int, minutes: Int)
    }

    interface Presenter : BasePresenter<View> {
        fun saveTime(hourOfDay: Int, minutes: Int)
        fun getSavedHour(): Int
        fun getSavedMinute(): Int
        fun getTimeUntilAlarmBoom(hourOfDay: Int, minutes: Int): Pair<Int, Int>
    }

}