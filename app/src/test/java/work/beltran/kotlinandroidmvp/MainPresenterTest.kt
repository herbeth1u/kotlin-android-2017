package work.beltran.kotlinandroidmvp

import io.reactivex.Scheduler
import io.reactivex.Single
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner
import work.beltran.kotlinandroidmvp.api.GithubService
import work.beltran.kotlinandroidmvp.api.Repo
import work.beltran.kotlinandroidmvp.rx.Schedulers
import work.beltran.kotlinandroidmvp.ui.MainPresenter
import work.beltran.kotlinandroidmvp.ui.MainView

@RunWith(MockitoJUnitRunner::class)
class MainPresenterTest {

    @Mock
    lateinit var service: work.beltran.kotlinandroidmvp.api.GithubService

    lateinit var presenter: MainPresenter


    @Before
    fun setUp() {
        presenter = MainPresenter(service, TestSchedulers)
    }

    @Test
    fun load_list_of_repos_and_hide_errors_When_attached_to_view() {
        val view = mock(MainView::class.java)
        val list = emptyList<work.beltran.kotlinandroidmvp.api.Repo>()
        `when`(service.listRepos("miquelbeltran")).thenReturn(Single.just(list))
        presenter.attachView(view)
        verify(view).hideError()
        verify(view).showList(list)
    }

    @Test
    fun show_error_message_When_attached_to_view_and_got_error() {
        val view = mock(MainView::class.java)
        `when`(service.listRepos("miquelbeltran")).thenReturn(Single.error(Throwable("Error")))
        presenter.attachView(view)
        verify(view).showError("Error")
    }

    @After
    fun tearDown() {
        presenter.detachView()
    }
}

object TestSchedulers : Schedulers {
    override fun io(): Scheduler = io.reactivex.schedulers.Schedulers.trampoline()
    override fun ui(): Scheduler = io.reactivex.schedulers.Schedulers.trampoline()
}
