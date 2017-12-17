package work.beltran.kotlinandroidmvp.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View.GONE
import android.view.View.VISIBLE
import kotlinx.android.synthetic.main.activity_main.*
import work.beltran.kotlinandroidmvp.App
import work.beltran.kotlinandroidmvp.R
import work.beltran.kotlinandroidmvp.api.Repo
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainView {
    @Inject
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as App).appComponent.inject(this)
    }

    override fun onStart() {
        super.onStart()
        presenter.attachView(this)
    }

    override fun onResume() {
        super.onResume()
        presenter.loadRepos()
    }

    override fun onStop() {
        presenter.detachView()
        super.onStop()
    }

    override fun showError(localizedMessage: String?) {
        textError.text = localizedMessage
        textError.visibility = VISIBLE
    }

    override fun showList(it: List<Repo>) {
        Log.e("D", it.toString())
    }

    override fun showLoading(show: Boolean) {
        progressBar.visibility = if (show) VISIBLE else GONE
    }

    override fun hideError() {
        textError.visibility = GONE
    }
}

