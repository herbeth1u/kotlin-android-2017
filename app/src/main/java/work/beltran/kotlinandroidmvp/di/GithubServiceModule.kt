package work.beltran.kotlinandroidmvp.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import work.beltran.kotlinandroidmvp.api.GithubService

@Module
class GithubServiceModule {

    @Provides
    fun retrofit() = Retrofit.Builder()
            .baseUrl("https://api.example.com")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

    @Provides
    fun githubService(retrofit: Retrofit) = retrofit.create(GithubService::class.java)
}