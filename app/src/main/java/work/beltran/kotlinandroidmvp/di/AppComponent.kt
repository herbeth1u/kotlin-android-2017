package work.beltran.kotlinandroidmvp.di

import dagger.Component
import work.beltran.kotlinandroidmvp.MainActivity

@Component
interface AppComponent {
    fun  inject(mainActivity: MainActivity)
}