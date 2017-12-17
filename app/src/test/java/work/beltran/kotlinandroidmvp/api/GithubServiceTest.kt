package work.beltran.kotlinandroidmvp.api

import org.junit.Test


class GithubServiceTest {
    var service = githubService(retrofit())

    @Test
    fun `get list of repos`() {
        val observer = service.listRepos("miquelbeltran").test()
        observer.assertNoErrors()
        observer.assertValue { it[0].name.isNotEmpty() }
    }
}