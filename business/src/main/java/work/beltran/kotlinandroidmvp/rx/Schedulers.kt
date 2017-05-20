package work.beltran.kotlinandroidmvp.rx

import io.reactivex.Scheduler

interface Schedulers {
    fun io() : Scheduler
    fun ui() : Scheduler
}


