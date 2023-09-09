package com.akash.singh.injections.modules

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.akash.singh.alarmSettings.optionSetRingtone.RingtoneManagerHelper
import com.akash.singh.tools.ConstantsPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {
    @Provides
    @Singleton
    fun provideSharedPreferences(app: Application): SharedPreferences = app.getSharedPreferences(ConstantsPreferences.ALARM_SP_NAME.getKeyValue(), Context.MODE_PRIVATE)

    @Provides
    fun provideRingtoneManagerHelper(context: Context) = RingtoneManagerHelper(context)

}