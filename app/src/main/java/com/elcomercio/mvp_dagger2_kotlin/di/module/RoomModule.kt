package com.elcomercio.mvp_dagger2_kotlin.di.module

import android.app.Application
import android.arch.persistence.room.Room
import com.elcomercio.mvp_dagger2_kotlin.data.repository.local.db.SampleDataBase
import com.elcomercio.mvp_dagger2_kotlin.utils.AppExecutors
import com.elcomercio.mvp_dagger2_kotlin.utils.DiskIOThreadExecutor
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executors
import javax.inject.Singleton

/**
 * @author carlosleonardocamilovargashuaman on 4/19/18.
 */
@Module
class RoomModule {

    @Singleton
    @Provides
    fun provideDb(context: Application): SampleDataBase =
            Room.databaseBuilder(
                    context.applicationContext,
                    SampleDataBase::class.java,
                    "Sample.db")
                    .build()

    @Singleton
    @Provides
    fun provideUserDao(sampleDataBase: SampleDataBase) = sampleDataBase.userDao()

    @Singleton
    @Provides
    fun provideAppExecutors() = AppExecutors(DiskIOThreadExecutor(),
            Executors.newFixedThreadPool(THREAD_COUNT),
            AppExecutors.MainThreadExecutor())

    companion object {
        const val THREAD_COUNT = 3
    }
}