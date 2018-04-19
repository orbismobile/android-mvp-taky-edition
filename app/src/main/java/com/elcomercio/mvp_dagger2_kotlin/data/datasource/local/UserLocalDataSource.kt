package com.elcomercio.mvp_dagger2_kotlin.data.datasource.local

import com.elcomercio.mvp_dagger2_kotlin.data.datasource.UserDataSource
import com.elcomercio.mvp_dagger2_kotlin.data.repository.local.db.dao.UserDao
import com.elcomercio.mvp_dagger2_kotlin.data.repository.local.db.entity.UserEntity
import com.elcomercio.mvp_dagger2_kotlin.utils.AppExecutors
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Carlos Vargas on 4/12/18.
 * @author Carlo Renzo on 4/12/18.
 * @version 1.0.5
 * @since 1.0.5
 */

@Singleton
class UserLocalDataSource
constructor(val appExecutors: AppExecutors, val userDao: UserDao) : UserDataSource {

    override fun getUsers(getUserCallback: UserDataSource.GetUserCallback) {
        val runnable = Runnable {
            val userList = userDao.getUsers()
            appExecutors.mainThread().execute {
                if (userList.isEmpty()) {
                    getUserCallback.onGetUserError("Any user available")
                } else {
                    getUserCallback.onGetUserSuccessful(userList)
                }
            }
        }
        appExecutors.diskIO().execute(runnable)
    }

    override fun saveUser(userEntity: UserEntity) {
        val saveRunnable = Runnable {
            userDao.insertUser(userEntity)
        }
        appExecutors.diskIO().execute(saveRunnable)
    }

    override fun updateUser(userEntity: UserEntity) {
        val updateRunnable = Runnable {
            userDao.updateUser(userEntity)
        }
        appExecutors.diskIO().execute(updateRunnable)
    }

    override fun deleteUser(userEntity: UserEntity) {
        val deleteRunnable = Runnable {
            userDao.deleteUser(userEntity)
        }
        appExecutors.diskIO().execute(deleteRunnable)
    }
}