package com.elcomercio.mvp_dagger2_kotlin.ui.user

import com.elcomercio.mvp_dagger2_kotlin.data.datasource.UserDataSource
import com.elcomercio.mvp_dagger2_kotlin.data.repository.local.db.entity.UserEntity
import com.elcomercio.mvp_dagger2_kotlin.di.annotations.Local
import com.elcomercio.mvp_dagger2_kotlin.di.annotations.Remote
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Carlos Vargas on 4/12/18.
 * @author Carlo Renzo on 4/12/18.
 * @version 1.0.5
 * @since 1.0.5
 */

@Singleton
class UserRepository
@Inject
constructor(@Local private val userLocalDataSource: UserDataSource,
            @Remote private val userRemoteDataSource: UserDataSource) : UserDataSource {

    override fun getUsers(getUserCallback: UserDataSource.GetUserCallback) {
        userLocalDataSource.getUsers(object : UserDataSource.GetUserCallback {
            override fun onGetUserSuccessful(userList: List<UserEntity>) {
                getUserCallback.onGetUserSuccessful(userList)
            }

            override fun onGetUserError(errorMessage: String) {
                getUsersFromDataSource(getUserCallback)
            }
        })
    }

    override fun saveUser(userEntity: UserEntity) {
        userLocalDataSource.saveUser(userEntity)
    }

    override fun updateUser(userEntity: UserEntity) {
        userLocalDataSource.updateUser(userEntity)
    }

    override fun deleteUser(userEntity: UserEntity) {
        userLocalDataSource.deleteUser(userEntity)
    }

    fun getUsersFromDataSource(getUserCallback: UserDataSource.GetUserCallback) {
        userRemoteDataSource.getUsers(object : UserDataSource.GetUserCallback {
            override fun onGetUserSuccessful(userList: List<UserEntity>) {
                getUserCallback.onGetUserSuccessful(userList)
            }

            override fun onGetUserError(errorMessage: String) {
                getUserCallback.onGetUserError(errorMessage)
            }
        })
    }
}