package work.beltran.kotlinandroidmvp.di

import dagger.Component
import work.beltran.kotlinandroidmvp.ui.MainActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [(GithubInteractorModule::class), (RxModule::class)])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}