package com.elcomercio.mvp_dagger2_kotlin.data.repository.local.db.dao

import android.arch.persistence.room.*
import com.elcomercio.mvp_dagger2_kotlin.data.repository.local.db.entity.UserEntity

/**
 * @author Carlos Vargas on 4/12/18.
 * @author Carlo Renzo on 4/12/18.
 */
@Dao
interface UserDao {

    @Query("SELECT * FROM UserEntity ORDER BY name")
    fun getUsers(): List<UserEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(userEntity: UserEntity)

    @Update
    fun updateUser(userEntity: UserEntity)

    @Delete
    fun deleteUser(userEntity: UserEntity)
}