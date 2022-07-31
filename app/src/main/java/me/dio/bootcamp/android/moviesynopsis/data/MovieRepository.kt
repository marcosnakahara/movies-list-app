package me.dio.bootcamp.android.moviesynopsis.data

class MovieRepository(
    private val movieDataSource: MovieDataSource
) {
    fun getAllMoviesFromDataSource() = movieDataSource.getAllMovies()
}