package com.elcomercio.mvp_dagger2_kotlin.ui.user

import android.os.Bundle
import com.elcomercio.mvp_dagger2_kotlin.R
import com.elcomercio.mvp_dagger2_kotlin.data.repository.local.db.entity.UserEntity
import com.elcomercio.mvp_dagger2_kotlin.utils.showToast
import dagger.android.support.DaggerAppCompatActivity

import kotlinx.android.synthetic.main.activity_user.*
import kotlinx.android.synthetic.main.content_user.*
import javax.inject.Inject

class UserActivity : DaggerAppCompatActivity(), UserContract.View {

    private lateinit var userAdapter: UserAdapter

    private var userList: MutableList<UserEntity> = mutableListOf()

    @Inject
    lateinit var userPresenter: UserPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        setSupportActionBar(toolbar)

        userAdapter = UserAdapter(userList, {
            //Item Click Listener
            showToast("Click User")
        }, { userEntity, position ->
            showToast("Delete User")
            userPresenter.clearSpecificUser(userEntity)
            userAdapter.deleteUser(position)
        })

        rvUser.adapter = userAdapter
        userPresenter.getAllUsers()

        fabAddNewUser.setOnClickListener { _ ->
            userPresenter.addNewUser(UserEntity(0, "CarlosVargas"))
        }

        fabGetLocalUsers.setOnClickListener { _ ->
            userPresenter.getAllUsers()
        }
    }

    override fun onResume() {
        super.onResume()
        userPresenter.takeView(this)
    }

    override fun onPause() {
        super.onPause()
        userPresenter.dropView()
    }

    override fun refreshUsersList(userList: List<UserEntity>) {
        userAdapter.addUsersList(userList)
    }

    override fun showUserInsertedSuccessfully() {
        showToast(getString(R.string.user_inserted_successfully))
    }

    override fun showUserRemovedSuccessfully() {
        showToast(getString(R.string.user_removed_successfully))
    }

    override fun showUserUpdateSuccessfully() {
        showToast(getString(R.string.user_updated_successfully))
    }

    override fun showEmptyUserList(message: String) {
        showToast(getString(R.string.empty_users_list))
    }
}
