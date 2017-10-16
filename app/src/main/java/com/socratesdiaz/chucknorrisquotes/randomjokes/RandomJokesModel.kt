package com.socratesdiaz.chucknorrisquotes.randomjokes

import com.socratesdiaz.chucknorrisquotes.api.Joke
import com.socratesdiaz.chucknorrisquotes.base.BaseModel
import io.reactivex.Observable
import org.json.JSONObject

/**
 * Created by socratesdiaz on 10/5/17.
 */
class RandomJokesModel : IRandomJokesModel, BaseModel() {
    override fun fetchRandomJoke() : Observable<Joke> {
        return apiService.getRandomJoke().map { it.value }
    }
}