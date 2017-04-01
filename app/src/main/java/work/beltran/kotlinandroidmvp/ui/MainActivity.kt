package work.beltran.kotlinandroidmvp.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.reactivex.disposables.CompositeDisposable
import work.beltran.kotlinandroidmvp.App
import work.beltran.kotlinandroidmvp.R
import work.beltran.kotlinandroidmvp.api.GithubService
import work.beltran.kotlinandroidmvp.api.Repo
import work.beltran.kotlinandroidmvp.rx.Schedulers
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainView {
    @Inject
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as App).appComponent.inject(this)
        presenter.attachView(this)
    }

    override fun onDestroy() {
        presenter.detachView()
        super.onDestroy()
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

class MainPresenter @Inject constructor(val service: GithubService,
                                        val schedulers: Schedulers) {
    private var view: MainView? = null
    private val composite = CompositeDisposable()

    fun attachView(view: MainView) {
        this.view = view
        composite.add(service.listRepos("miquelbeltran")
                .subscribeOn(schedulers.io())
                .observeOn(schedulers.ui())
                .doOnSubscribe { this.view?.showLoading(true) }
                .doOnDispose { this.view?.showLoading(false) }
                .subscribe(this::onNext, this::onError))
    }

    private fun onNext(list: List<Repo>) {
        view?.hideError()
        view?.showList(list)
    }

    private fun onError(throwable: Throwable) {
        view?.showError(throwable.localizedMessage)
    }

    fun detachView() {
        composite.clear()
        this.view = null
    }
}

interface MainView {
    fun showError(localizedMessage: String?)
    fun showList(it: List<Repo>)
    fun showLoading(b: Boolean)
    fun hideError()
}

