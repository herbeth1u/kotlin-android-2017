package work.beltran.kotlinandroidmvp.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class GithubServiceModule {

    @Provides
    @Singleton
    fun retrofit() = work.beltran.kotlinandroidmvp.api.retrofit()

    @Provides
    @Singleton
    fun githubService(retrofit: Retrofit) = work.beltran.kotlinandroidmvp.api.githubService(retrofit)
}