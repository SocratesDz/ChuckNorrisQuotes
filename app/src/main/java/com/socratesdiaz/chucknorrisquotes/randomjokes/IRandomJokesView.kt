package com.socratesdiaz.chucknorrisquotes.randomjokes

import com.socratesdiaz.chucknorrisquotes.api.Joke
import com.socratesdiaz.chucknorrisquotes.base.MvpView

/**
 * Created by socratesdiaz on 10/5/17.
 */
interface IRandomJokesView : MvpView {
    fun showJoke(joke: Joke)
}