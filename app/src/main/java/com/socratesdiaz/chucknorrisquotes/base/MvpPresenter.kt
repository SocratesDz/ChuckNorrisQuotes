package com.socratesdiaz.chucknorrisquotes.base

/**
 * Created by socratesdiaz on 10/5/17.
 */
interface MvpPresenter<in V: MvpView> {
    fun attachView(view: V)
    fun detachView()
}