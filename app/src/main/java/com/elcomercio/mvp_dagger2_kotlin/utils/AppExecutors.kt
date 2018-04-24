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
class AppExecutors(val diskIO: Executor, val networkIO: Executor, val mainThread: Executor) {

    class MainThreadExecutor : Executor {
        private val mainThreadHandler = Handler(Looper.getMainLooper())
        override fun execute(command: Runnable) {
            mainThreadHandler.post(command)
        }
    }
}