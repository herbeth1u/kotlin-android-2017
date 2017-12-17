package work.beltran.kotlinandroidmvp

import io.reactivex.Single
import work.beltran.kotlinandroidmvp.api.Repo

interface GithubInteractor {
    fun reposFor(username: String): Single<List<Repo>>
}