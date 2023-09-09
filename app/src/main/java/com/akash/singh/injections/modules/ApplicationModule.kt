package com.akash.singh.injections.modules

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module



@Module
public abstract class ApplicationModule {
    @Binds
    abstract fun provideAppContext(app: Application): Context

}