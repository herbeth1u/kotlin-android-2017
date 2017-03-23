package work.beltran.kotlinandroidmvp.rx

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

interface Schedulers {
    fun io() : Scheduler
    fun ui() : Scheduler
}

class AndroidSchedulers @Inject constructor(): Schedulers {
    override fun io(): Scheduler = io.reactivex.schedulers.Schedulers.io()
    override fun ui(): Scheduler = AndroidSchedulers.mainThread()
}

