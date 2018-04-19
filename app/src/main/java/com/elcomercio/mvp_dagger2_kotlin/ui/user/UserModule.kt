package com.elcomercio.mvp_dagger2_kotlin.ui.user

import com.elcomercio.mvp_dagger2_kotlin.di.annotations.ActivityScoped
import dagger.Binds
import dagger.Module

/**
 * @author Carlos Vargas on 4/12/18.
 * @author Carlo Renzo on 4/12/18.
 * @version 1.0.5
 * @since 1.0.5
 */

@Module
abstract class UserModule {

    @ActivityScoped
    @Binds
    abstract fun provideUserPresenter(userPresenter: UserPresenter): UserContract.Presenter
}