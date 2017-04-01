package work.beltran.kotlinandroidmvp.di

import dagger.Module
import dagger.Provides
import work.beltran.kotlinandroidmvp.rx.AndroidSchedulers
import work.beltran.kotlinandroidmvp.rx.Schedulers

@Module
class RxModule {

    @Provides
    fun schedulers() : Schedulers = AndroidSchedulers
}