package me.dio.bootcamp.android.moviesynopsis.framework.api

import me.dio.bootcamp.android.moviesynopsis.domain.Movie
import retrofit2.Call
import retrofit2.http.GET

interface MovieApi {

    @GET("movies-list-api/moviesList.json")
    fun getAllMovies(): Call<List<Movie>>
}