package work.beltran.kotlinandroidmvp.di

import dagger.Component
import work.beltran.kotlinandroidmvp.ui.MainActivity

@Component(
        modules = arrayOf(
                GithubServiceModule::class,
                RxModule::class
        )
)
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}