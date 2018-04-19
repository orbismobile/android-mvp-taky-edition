package com.elcomercio.mvp_dagger2_kotlin.di.module

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module

@Module
abstract class ApplicationModule {
    @Binds
    internal abstract fun provideContext(application: Application): Context
}