package com.akash.singh.alarms.mathAlarm.displayAlarm

import com.akash.singh.data.AlarmDataHelper
import com.akash.singh.injections.scope.ActivityScope
import dagger.Module
import dagger.Provides

@Module
class DisplayAlarmModule {
    @ActivityScope
    @Provides
    fun provideDisplayViewModel(data: AlarmDataHelper) = DisplayAlarmViewModel(data)
}