package com.elcomercio.mvp_dagger2_kotlin.common

interface BasePresenter<T> {

    fun takeView(view: T)
    fun dropView()
}