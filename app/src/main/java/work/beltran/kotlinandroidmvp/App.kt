package work.beltran.kotlinandroidmvp

import android.app.Application
import work.beltran.kotlinandroidmvp.di.AppComponent
import work.beltran.kotlinandroidmvp.di.DaggerAppComponent

class App : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }
}