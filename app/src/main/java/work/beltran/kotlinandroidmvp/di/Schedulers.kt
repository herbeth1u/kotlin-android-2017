package work.beltran.kotlinandroidmvp.di

import io.reactivex.Scheduler

interface Schedulers {
    fun io(): Scheduler
    fun ui(): Scheduler
}