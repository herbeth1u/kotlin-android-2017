package work.beltran.kotlinandroidmvp.ui

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.BehaviorSubject
import work.beltran.kotlinandroidmvp.GithubInteractor
import work.beltran.kotlinandroidmvp.api.Repo
import work.beltran.kotlinandroidmvp.rx.Schedulers
import javax.inject.Inject
import javax.inject.Named

class ReposViewModel
@Inject constructor(@Named("username") val username: String,
                    val interactor: GithubInteractor,
                    val schedulers: Schedulers) {
    val repos: BehaviorSubject<List<Repo>> = BehaviorSubject.create()
    private val composite = CompositeDisposable()

    init {
        refresh()
    }

    fun refresh() {
        composite.add(interactor.reposFor(username).subscribe(repos::onNext, repos::onError))
    }
}