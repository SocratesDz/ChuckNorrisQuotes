package com.socratesdiaz.chucknorrisquotes.randomjokes

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import butterknife.Unbinder

import com.socratesdiaz.chucknorrisquotes.R
import com.socratesdiaz.chucknorrisquotes.api.Joke
import com.socratesdiaz.chucknorrisquotes.base.BaseActivity

class RandomJokesActivity : BaseActivity(), IRandomJokesView {

    lateinit var presenter : IRandomJokesPresenter<IRandomJokesView>
    @BindView(R.id.reloadButton) lateinit var reloadButton : Button
    @BindView(R.id.loadingBar) lateinit var loadingProgressBar : ProgressBar
    @BindView(R.id.jokeContent) lateinit var jokeContent : TextView
    var unbinder : Unbinder? = null

    var joke : Joke? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random_jokes)
        unbinder = ButterKnife.bind(this)
        presenter = RandomJokesPresenter(RandomJokesModel())
        presenter.attachView(this)
        loadJoke()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
        unbinder?.unbind()
    }

    @OnClick(R.id.reloadButton)
    fun loadJoke() {
        presenter.loadJoke()
    }

    override fun showJoke(joke : Joke) {
        this.joke = joke
        this.joke?.let {
            jokeContent.text = it.content
        }
    }

    override fun showLoadingScreen(enabled: Boolean) {
        if (enabled) {
            reloadButton.visibility = View.GONE
            loadingProgressBar.visibility = View.VISIBLE
        }
        else {
            loadingProgressBar.visibility = View.GONE
            reloadButton.visibility = View.VISIBLE
        }
    }
}
