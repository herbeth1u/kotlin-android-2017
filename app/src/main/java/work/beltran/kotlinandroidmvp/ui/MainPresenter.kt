package work.beltran.kotlinandroidmvp.ui

import io.reactivex.disposables.CompositeDisposable
import work.beltran.kotlinandroidmvp.api.GithubService
import work.beltran.kotlinandroidmvp.api.Repo
import work.beltran.kotlinandroidmvp.di.Schedulers
import javax.inject.Inject

class MainPresenter @Inject constructor(val interactor: GithubService, val schedulers: Schedulers) {
    private var view: MainView? = null
    private val composite = CompositeDisposable()

    fun attachView(view: MainView) {
        this.view = view
    }

    fun loadRepos() {
        composite.add(interactor.listRepos("herbeth1u")
                .subscribeOn(schedulers.io())
                .observeOn(schedulers.ui())
                .doOnSubscribe { view?.showLoading(true) }
                .doOnDispose { view?.showLoading(false) }
                .doOnSuccess { view?.showLoading(false) }
                .doOnError { view?.showLoading(false) }
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