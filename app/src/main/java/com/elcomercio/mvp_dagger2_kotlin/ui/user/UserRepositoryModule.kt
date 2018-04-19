package com.elcomercio.mvp_dagger2_kotlin.ui.user

import com.elcomercio.mvp_dagger2_kotlin.data.datasource.UserDataSource
import com.elcomercio.mvp_dagger2_kotlin.data.datasource.local.UserLocalDataSource
import com.elcomercio.mvp_dagger2_kotlin.data.datasource.remote.UserRemoteDataSource
import com.elcomercio.mvp_dagger2_kotlin.data.repository.local.db.dao.UserDao
import com.elcomercio.mvp_dagger2_kotlin.di.annotations.Local
import com.elcomercio.mvp_dagger2_kotlin.di.annotations.Remote
import com.elcomercio.mvp_dagger2_kotlin.data.repository.remote.api.SampleApi
import com.elcomercio.mvp_dagger2_kotlin.utils.AppExecutors
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author Carlos Vargas on 4/12/18.
 * @author Carlo Renzo on 4/12/18.
 * @version 1.0.5
 * @since 1.0.5
 */

@Module
class UserRepositoryModule {

    @Singleton
    @Provides
    @Local
    fun provideUserLocalDataSource(appExecutors: AppExecutors, userDao: UserDao): UserDataSource =
            UserLocalDataSource(appExecutors, userDao)

    @Singleton
    @Provides
    @Remote
    fun provideUserRemoteDataSource(sampleApi: SampleApi): UserDataSource = UserRemoteDataSource(sampleApi)
}