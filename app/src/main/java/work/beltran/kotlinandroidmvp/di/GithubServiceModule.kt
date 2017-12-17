package work.beltran.kotlinandroidmvp.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import work.beltran.kotlinandroidmvp.api.GithubService
import javax.inject.Singleton

@Module
class GithubServiceModule {
    @Provides
    @Singleton
    fun retrofit(): Retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

    @Provides
    @Singleton
    fun githubService(retrofit: Retrofit): GithubService = retrofit.create(GithubService::class.java)
}