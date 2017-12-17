package work.beltran.kotlinandroidmvp.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import work.beltran.kotlinandroidmvp.model.Repo

interface GithubService {
    @GET("users/{user}/repos")
    fun listRepos(@Path("user") user: String): Single<List<Repo>>
}