package com.elcomercio.mvp_dagger2_kotlin.data.repository.local.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.elcomercio.mvp_dagger2_kotlin.data.repository.local.db.dao.UserDao
import com.elcomercio.mvp_dagger2_kotlin.data.repository.local.db.entity.UserEntity

/**
 * @author Carlos Vargas on 4/12/18.
 * @author Carlo Renzo on 4/12/18.
 */
@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class SampleDataBase : RoomDatabase() {
    abstract fun userDao(): UserDao
}