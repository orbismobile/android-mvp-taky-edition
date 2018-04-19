package com.elcomercio.mvp_dagger2_kotlin.app

import com.elcomercio.mvp_dagger2_kotlin.ui.user.UserRepository
import com.elcomercio.mvp_dagger2_kotlin.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Inject

/**
 * @author carlosleonardocamilovargashuaman on 4/12/18.
 */
class SampleApplication : DaggerApplication() {

    @Inject
    lateinit var userRepository: UserRepository

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }


}