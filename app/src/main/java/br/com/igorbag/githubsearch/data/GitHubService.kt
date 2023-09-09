package br.com.igorbag.githubsearch.data

import br.com.igorbag.githubsearch.domain.Repository
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {

    // https://github.com/ + GuilhermeVasconcellos?tab=repositories
//    @GET("{user}?tab=repositories")
    @GET("users/{user}/repos")
    fun getAllRepositoriesByUser(@Path("user") user: String): Call<List<Repository>>

}
