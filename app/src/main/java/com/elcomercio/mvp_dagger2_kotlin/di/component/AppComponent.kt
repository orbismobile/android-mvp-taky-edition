package com.elcomercio.mvp_dagger2_kotlin.di.component

import android.app.Application
import com.elcomercio.mvp_dagger2_kotlin.app.SampleApplication
import com.elcomercio.mvp_dagger2_kotlin.di.module.ActivityBindingModule
import com.elcomercio.mvp_dagger2_kotlin.di.module.ApplicationModule
import com.elcomercio.mvp_dagger2_kotlin.di.module.RetrofitModule
import com.elcomercio.mvp_dagger2_kotlin.di.module.RoomModule
import com.elcomercio.mvp_dagger2_kotlin.ui.user.UserRepositoryModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ApplicationModule::class,
    ActivityBindingModule::class,
    RetrofitModule::class,
    AndroidSupportInjectionModule::class,
    UserRepositoryModule::class,
    RoomModule::class
])
interface AppComponent : AndroidInjector<SampleApplication> {
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): AppComponent.Builder

        fun build(): AppComponent
    }
}