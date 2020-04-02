package dev.sanggi.homework.work4.model.service

import dev.sanggi.homework.work4.model.Repo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET("users/{user}/repos")
    fun getRepos(@Path("user") userName: String): Call<ArrayList<Repo>>

}