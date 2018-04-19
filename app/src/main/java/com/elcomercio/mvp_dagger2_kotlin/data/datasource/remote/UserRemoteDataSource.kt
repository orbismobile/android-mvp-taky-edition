package com.elcomercio.mvp_dagger2_kotlin.data.datasource.remote

import com.elcomercio.mvp_dagger2_kotlin.data.datasource.UserDataSource
import com.elcomercio.mvp_dagger2_kotlin.data.repository.local.db.entity.UserEntity
import com.elcomercio.mvp_dagger2_kotlin.data.repository.remote.api.SampleApi
import com.elcomercio.mvp_dagger2_kotlin.data.repository.remote.model.response.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Singleton

/**
 * @author Carlos Vargas on 4/12/18.
 * @author Carlo Renzo on 4/12/18.
 * @version 1.0.5
 * @since 1.0.5
 */
@Singleton
class UserRemoteDataSource(private val sampleApi: SampleApi) : UserDataSource {

    override fun getUsers(getUserCallback: UserDataSource.GetUserCallback) {
        sampleApi.getUser().enqueue(object : Callback<List<UserResponse>> {

            override fun onResponse(call: Call<List<UserResponse>>?, response: Response<List<UserResponse>>?) {
                if (response!!.isSuccessful) {
                    //MAPPING
                    val mappedUserList: List<UserEntity> = response.body()!!.map {
                        UserEntity(it.id, it.name!!)
                    }

                    getUserCallback.onGetUserSuccessful(mappedUserList)
                } else {
                    getUserCallback.onGetUserError(response.message())
                }
            }

            override fun onFailure(call: Call<List<UserResponse>>?, t: Throwable?) {
                getUserCallback.onGetUserError("${t!!.message}")
            }
        })
    }

    override fun saveUser(userEntity: UserEntity) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateUser(userEntity: UserEntity) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteUser(userEntity: UserEntity) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}