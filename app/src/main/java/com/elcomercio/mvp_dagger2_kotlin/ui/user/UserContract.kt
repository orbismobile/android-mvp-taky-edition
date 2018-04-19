package com.elcomercio.mvp_dagger2_kotlin.ui.user

import com.elcomercio.mvp_dagger2_kotlin.common.BasePresenter
import com.elcomercio.mvp_dagger2_kotlin.common.BaseView
import com.elcomercio.mvp_dagger2_kotlin.data.repository.local.db.entity.UserEntity

/**
 * @author Carlos Vargas on 4/12/18.
 * @author Carlo Renzo on 4/12/18.
 * @version 1.0.5
 * @since 1.0.5
 */
interface UserContract {

    interface View : BaseView<Presenter> {

        fun refreshUsersList(userList: List<UserEntity>)
        fun showEmptyUserList(message: String)
        fun showUserInsertedSuccessfully()
        fun showUserRemovedSuccessfully()
        fun showUserUpdateSuccessfully()
    }

    interface Presenter : BasePresenter<View> {
        fun getAllUsers()
        fun clearSpecificUser(userEntity: UserEntity)
        fun addNewUser(userEntity: UserEntity)
    }
}