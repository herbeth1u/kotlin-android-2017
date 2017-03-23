package work.beltran.kotlinandroidmvp.di

import dagger.Component
import work.beltran.kotlinandroidmvp.MainActivity

@Component(
        modules = arrayOf(GithubServiceModule::class)
)
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}