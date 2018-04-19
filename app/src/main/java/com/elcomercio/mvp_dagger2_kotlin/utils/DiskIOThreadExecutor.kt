package com.elcomercio.mvp_dagger2_kotlin.utils

import java.util.concurrent.Executor
import java.util.concurrent.Executors

/**
 * @author Carlos Vargas on 4/12/18.
 * @author Carlo Renzo on 4/12/18.
 */
class DiskIOThreadExecutor : Executor {

    private val mDiskIO = Executors.newSingleThreadExecutor()

    override fun execute(command: Runnable?) {
        mDiskIO.execute(command)
    }
}