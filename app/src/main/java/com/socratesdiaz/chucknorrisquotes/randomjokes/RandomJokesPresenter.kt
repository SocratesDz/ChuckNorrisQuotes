package com.socratesdiaz.chucknorrisquotes.randomjokes

import com.socratesdiaz.chucknorrisquotes.api.Joke
import com.socratesdiaz.chucknorrisquotes.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

/**
 * Created by socratesdiaz on 10/5/17.
 */
class RandomJokesPresenter<V: IRandomJokesView>(val model: IRandomJokesModel)
    : IRandomJokesPresenter<V>, BasePresenter<V>() {

    override fun loadJoke() {
        view?.showLoadingScreen(true)
        model.fetchRandomJoke()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(object : DisposableObserver<Joke>() {
                    override fun onNext(t: Joke) {
                        view?.showJoke(t)
                    }

                    override fun onComplete() {
                        view?.showLoadingScreen(false)
                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }
                })
    }
}