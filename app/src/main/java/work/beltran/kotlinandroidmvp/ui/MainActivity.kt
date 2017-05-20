package work.beltran.kotlinandroidmvp.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
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
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showList(it: List<Repo>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showLoading(b: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

