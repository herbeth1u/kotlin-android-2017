package work.beltran.kotlinandroidmvp.di

import dagger.Module
import dagger.Provides
import work.beltran.kotlinandroidmvp.GithubInteractor
import work.beltran.kotlinandroidmvp.rx.Schedulers
import work.beltran.kotlinandroidmvp.ui.ReposViewModel

@Module(includes = arrayOf(
        GithubInteractorModule::class,
        RxModule::class
))
class ReposViewModelModule(val username: String) {

    @Provides
    fun provideViewModel(interactor: GithubInteractor, schedulers: Schedulers) : ReposViewModel {
        return ReposViewModel(username, interactor, schedulers)
    }
}

