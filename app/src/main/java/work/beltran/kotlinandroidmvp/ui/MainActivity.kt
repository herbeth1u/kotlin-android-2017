package work.beltran.kotlinandroidmvp.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import io.reactivex.disposables.CompositeDisposable
import work.beltran.kotlinandroidmvp.App
import work.beltran.kotlinandroidmvp.R
import work.beltran.kotlinandroidmvp.api.Repo
import work.beltran.kotlinandroidmvp.di.DaggerAppComponent
import work.beltran.kotlinandroidmvp.di.ReposViewModelModule
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainView {
    @Inject
    lateinit var viewModel: ReposViewModel
    private val composite = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DaggerAppComponent.builder()
                .reposViewModelModule(ReposViewModelModule("miquelbeltran"))
                .build()
                .inject(this)
    }

    override fun onStart() {
        super.onStart()
        viewModel.repos.subscribe(this::showList, { showError(it.localizedMessage) })
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onStop() {
        composite.clear()
        super.onStop()
    }

    override fun showError(localizedMessage: String) {
        Log.e("MainActivity", localizedMessage)
    }

    override fun showList(it: List<Repo>) {
        Log.d("MainActivity", it.toString())
    }

    override fun showLoading(b: Boolean) {
    }

    override fun hideError() {
    }
}

