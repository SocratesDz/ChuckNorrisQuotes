package com.socratesdiaz.chucknorrisquotes.randomjokes

import com.socratesdiaz.chucknorrisquotes.api.Joke
import com.socratesdiaz.chucknorrisquotes.base.MvpModel
import io.reactivex.Observable

/**
 * Created by socratesdiaz on 10/5/17.
 */
interface IRandomJokesModel : MvpModel {
    fun fetchRandomJoke() : Observable<Joke>
}