package com.elcomercio.mvp_dagger2_kotlin.data.repository.remote.api

import com.elcomercio.mvp_dagger2_kotlin.BuildConfig
import com.elcomercio.mvp_dagger2_kotlin.data.repository.remote.model.response.UserResponse
import retrofit2.Call
import retrofit2.http.GET

/**
 * @author Carlos Vargas on 4/12/18.
 * @author Carlo Renzo on 4/12/18.
 * @version 1.0.5
 * @since 1.0.5
 */
interface SampleApi {

    @GET(BuildConfig.USERS)
    fun getUser(): Call<List<UserResponse>>
}