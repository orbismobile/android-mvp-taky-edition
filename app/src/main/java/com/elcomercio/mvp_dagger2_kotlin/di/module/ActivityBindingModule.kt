package com.elcomercio.mvp_dagger2_kotlin.di.module

import com.elcomercio.mvp_dagger2_kotlin.di.annotations.ActivityScoped
import com.elcomercio.mvp_dagger2_kotlin.ui.user.UserActivity
import com.elcomercio.mvp_dagger2_kotlin.ui.user.UserModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = [UserModule::class])
    abstract fun userActivity(): UserActivity

}