package com.akash.singh.injections.modules

import com.akash.singh.alarmSettings.mainSettings.AlarmSettingsActivity
import com.akash.singh.alarmSettings.mainSettings.AlarmSettingsModule
import com.akash.singh.alarmSettings.optionDeepWakeUp.FragmentOptionSetDeepWakeUp
import com.akash.singh.alarmSettings.optionDeepWakeUp.OptionSetDeepWakeUpModule
import com.akash.singh.alarmSettings.optionSetRingtone.FragmentOptionSetRingtone
import com.akash.singh.alarmSettings.optionSetRingtone.OptionSetRingtoneModule
import com.akash.singh.alarmSettings.optionSetTime.FragmentOptionSetTime
import com.akash.singh.alarmSettings.optionSetTime.OptionSetTimeModule
import com.akash.singh.alarms.mathAlarm.displayAlarm.DisplayAlarmActivity
import com.akash.singh.alarms.mathAlarm.displayAlarm.DisplayAlarmModule
import com.akash.singh.alarms.mathAlarm.mainAlarm.MainAlarmActivity
import com.akash.singh.alarms.mathAlarm.mainAlarm.MainAlarmModule
import com.akash.singh.alarms.mathAlarm.services.displayAlarmService.DisplayAlarmService
import com.akash.singh.alarms.mathAlarm.services.displayAlarmService.DisplayAlarmServiceModule
import com.akash.singh.injections.scope.ActivityScope
import com.akash.singh.injections.scope.DisplayAlarmServiceScope
import com.akash.singh.injections.scope.FragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
public abstract class ActivityBindingModule {
    @FragmentScope
    @ContributesAndroidInjector(modules = [(OptionSetTimeModule::class), (DisplayHelperModule::class)])
    public abstract fun optionSetTimeFragment(): FragmentOptionSetTime

    @FragmentScope
    @ContributesAndroidInjector(modules = [(OptionSetRingtoneModule::class), (DisplayHelperModule::class), (MediaPlayerHelperModule::class)])
    public abstract fun getOptionSetRingtoneFragement(): FragmentOptionSetRingtone

    @ActivityScope
    @ContributesAndroidInjector(modules = [(DisplayHelperModule::class), (AlarmSettingsModule::class)])
    public abstract fun getAlarmSettingActivty(): AlarmSettingsActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [(MainAlarmModule::class), (DisplayHelperModule::class)])
    public abstract fun getMainAlarmActivity(): MainAlarmActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [(DisplayAlarmModule::class), (DisplayHelperModule::class)])
    public abstract fun getDisplayAlarmActivity(): DisplayAlarmActivity

    @DisplayAlarmServiceScope
    @ContributesAndroidInjector(modules = [(DisplayAlarmServiceModule::class), (DisplayHelperModule::class), (MediaPlayerHelperModule::class)])
    public abstract fun getDisplayAlarmService(): DisplayAlarmService

    @FragmentScope
    @ContributesAndroidInjector(modules = [(OptionSetDeepWakeUpModule::class), (MediaPlayerHelperModule::class)])
    public abstract fun getFragmentOptionSetDeepWakeUp(): FragmentOptionSetDeepWakeUp
}