package com.elcomercio.mvp_dagger2_kotlin.ui.user

import com.elcomercio.mvp_dagger2_kotlin.data.datasource.UserDataSource
import com.elcomercio.mvp_dagger2_kotlin.data.repository.local.db.entity.UserEntity
import com.elcomercio.mvp_dagger2_kotlin.di.annotations.ActivityScoped
import javax.inject.Inject

/**
 * @author Carlos Vargas on 4/12/18.
 * @author Carlo Renzo on 4/12/18.
 *
 */
@ActivityScoped
class UserPresenter @Inject constructor(var userRepository: UserRepository) : UserContract.Presenter {

    private var userView: UserContract.View? = null

    override fun takeView(view: UserContract.View) {
        userView = view
    }

    override fun dropView() {
        userView = null
    }

    override fun getAllUsers() {
        userRepository.getUsers(object : UserDataSource.GetUserCallback {
            override fun onGetUserSuccessful(userList: List<UserEntity>) {
                if (userView != null) {
                    userView!!.refreshUsersList(userList)
                }
            }

            override fun onGetUserError(errorMessage: String) {
                if (userView != null) {
                    userView!!.showEmptyUserList(errorMessage)
                }
            }
        })
    }

    override fun clearSpecificUser(userEntity: UserEntity) {
        userRepository.deleteUser(userEntity)
    }

    override fun addNewUser(userEntity: UserEntity) {
        userRepository.saveUser(userEntity)
    }
}