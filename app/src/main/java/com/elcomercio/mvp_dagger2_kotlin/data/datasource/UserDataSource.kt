package com.elcomercio.mvp_dagger2_kotlin.data.datasource

import com.elcomercio.mvp_dagger2_kotlin.data.repository.local.db.entity.UserEntity

/**
 * @author Carlos Vargas on 4/12/18.
 * @author Carlo Renzo on 4/12/18.
 * @version 1.0.5
 * @since 1.0.5
 */
interface UserDataSource {

    //Db
    interface GetUserCallback {
        fun onGetUserSuccessful(userList: List<UserEntity>)
        fun onGetUserError(errorMessage: String)
    }

    interface RemoteUserCallback {
        fun onUserSuccessful()
        fun onPostUserError()
        fun onPostUserFailure()
    }


    //Local or Remote functions
    fun getUsers(getUserCallback: GetUserCallback)

    fun saveUser(userEntity: UserEntity)
    fun updateUser(userEntity: UserEntity)
    fun deleteUser(userEntity: UserEntity)
}