package work.beltran.kotlinandroidmvp.github

import io.reactivex.Single
import work.beltran.kotlinandroidmvp.GithubInteractor
import work.beltran.kotlinandroidmvp.api.GithubService
import work.beltran.kotlinandroidmvp.api.Repo
import work.beltran.kotlinandroidmvp.rx.Schedulers
import javax.inject.Inject

class GithubInteractorImpl
@Inject constructor(val service: GithubService,
                    val schedulers: Schedulers)
    : GithubInteractor {

    override fun reposFor(username: String): Single<List<Repo>> {
        return service.listRepos(username).subscribeOn(schedulers.io())
    }
}