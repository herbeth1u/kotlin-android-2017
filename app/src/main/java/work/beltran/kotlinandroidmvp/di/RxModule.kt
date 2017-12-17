package work.beltran.kotlinandroidmvp.di

import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import work.beltran.kotlinandroidmvp.rx.Schedulers
import javax.inject.Singleton

@Module
class RxModule {

    @Provides
    @Singleton
    fun schedulers(): Schedulers = SchedulersApp
}

object SchedulersApp : Schedulers {
    override fun io(): Scheduler = io.reactivex.schedulers.Schedulers.io()
    override fun ui(): Scheduler = AndroidSchedulers.mainThread()
}
