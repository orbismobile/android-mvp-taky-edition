package com.elcomercio.mvp_dagger2_kotlin.utils

import android.os.Handler
import android.os.Looper

import java.util.concurrent.Executor
import javax.inject.Singleton

/**
 * @author Carlos Vargas on 4/12/18.
 * @author Carlo Renzo on 4/12/18.
 */

@Singleton
class AppExecutors(private val diskIO: Executor, private val networkIO: Executor, private val mainThread: Executor) {

    fun diskIO(): Executor {
        return diskIO
    }

    fun networkIO(): Executor {
        return networkIO
    }

    fun mainThread(): Executor {
        return mainThread
    }

    class MainThreadExecutor : Executor {
        private val mainThreadHandler = Handler(Looper.getMainLooper())
        override fun execute(command: Runnable) {
            mainThreadHandler.post(command)
        }
    }
}