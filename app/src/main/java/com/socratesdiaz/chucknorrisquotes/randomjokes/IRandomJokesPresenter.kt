package com.socratesdiaz.chucknorrisquotes.randomjokes

import com.socratesdiaz.chucknorrisquotes.base.MvpPresenter

/**
 * Created by socratesdiaz on 10/5/17.
 */
interface IRandomJokesPresenter<V: IRandomJokesView> : MvpPresenter<V> {
    fun loadJoke()
}