package work.beltran.kotlinandroidmvp.di

import dagger.Module
import dagger.Provides
import work.beltran.kotlinandroidmvp.GithubInteractor
import work.beltran.kotlinandroidmvp.github.GithubInteractorImpl
import javax.inject.Singleton

@Module(includes = [(GithubServiceModule::class), (RxModule::class)])
class GithubInteractorModule {
    @Provides
    @Singleton
    fun provideGithubInteractor(githubInteractorImpl: GithubInteractorImpl): GithubInteractor {
        return githubInteractorImpl
    }
}