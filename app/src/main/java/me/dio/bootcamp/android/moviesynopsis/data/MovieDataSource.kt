package me.dio.bootcamp.android.moviesynopsis.data

import me.dio.bootcamp.android.moviesynopsis.domain.Movie

interface MovieDataSource {

    fun getAllMovies(): List<Movie>
}