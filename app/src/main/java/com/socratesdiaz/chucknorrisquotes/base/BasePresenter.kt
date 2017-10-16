package com.socratesdiaz.chucknorrisquotes.base

/**
 * Created by socratesdiaz on 10/5/17.
 */
abstract class BasePresenter<V: MvpView> : MvpPresenter<V> {
    var view: V? = null

    override fun attachView(view: V) {
        this.view = view
    }

    override fun detachView() {
        this.view = null
    }
}