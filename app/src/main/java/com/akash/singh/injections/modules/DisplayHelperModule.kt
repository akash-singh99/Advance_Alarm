package com.akash.singh.injections.modules

import android.content.Context
import com.akash.singh.tools.NotificationTools
import dagger.Module
import dagger.Provides


@Module
class DisplayHelperModule {
    @Provides
    fun getNotificationsTools(context: Context) = NotificationTools(context)
}