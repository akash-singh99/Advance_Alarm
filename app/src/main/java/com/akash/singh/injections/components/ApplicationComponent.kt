package com.akash.singh.injections.components

import android.app.Application
import com.akash.singh.SmartAlarmApp
import com.akash.singh.data.AlarmDataHelper
import com.akash.singh.injections.modules.ActivityBindingModule
import com.akash.singh.injections.modules.ApplicationModule
import com.akash.singh.injections.modules.DataModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(modules = [(ApplicationModule::class),
    (DataModule::class),
    (AndroidSupportInjectionModule::class),
    (ActivityBindingModule::class)])
public interface ApplicationComponent : AndroidInjector<SmartAlarmApp> {

    public fun getAlarmDataHelper(): AlarmDataHelper

    @Component.Builder
    public interface Builder {
        @BindsInstance
        fun application(app: Application): ApplicationComponent.Builder

        fun build(): ApplicationComponent
    }
}