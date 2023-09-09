package com.akash.singh.alarms.mathAlarm.mainAlarm

import android.content.Intent
import com.akash.singh.alarmSettings.mainSettings.AlarmSettingsActivity
import com.akash.singh.data.AlarmDataHelper
import com.akash.singh.injections.scope.ActivityScope
import com.akash.singh.tools.NotificationTools
import dagger.Module
import dagger.Provides

@Module
public class MainAlarmModule {
    @ActivityScope
    @Provides
    fun provideMainAlarmViewModel(data: AlarmDataHelper) = MainAlarmViewModel(data)

    @ActivityScope
    @Provides
    fun provideAlarmSettingIntent(activity: MainAlarmActivity): Intent {
        return Intent(activity, AlarmSettingsActivity::class.java)
    }

    @ActivityScope
    @Provides
    fun provideUserHelper(activity: MainAlarmActivity, intent: Intent) =
            UserHelper(activity, intent)

    @ActivityScope
    @Provides
    fun providePreviewOfAlarmSettings(activity: MainAlarmActivity, viewModule: MainAlarmViewModel,
                                      notificationsTools: NotificationTools) =
            PreviewOfAlarmSettings(activity, viewModule, notificationsTools)


}