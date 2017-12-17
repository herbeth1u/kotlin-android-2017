package work.beltran.kotlinandroidmvp.ui

import work.beltran.kotlinandroidmvp.api.Repo

interface MainView {
    fun showError(localizedMessage: String?)
    fun showList(it: List<Repo>)
    fun showLoading(show: Boolean)
    fun hideError()
}