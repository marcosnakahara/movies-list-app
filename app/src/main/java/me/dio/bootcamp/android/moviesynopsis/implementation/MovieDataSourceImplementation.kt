package me.dio.bootcamp.android.moviesynopsis.implementation

import android.util.Log
import me.dio.bootcamp.android.moviesynopsis.framework.api.MovieRestApiTask
import me.dio.bootcamp.android.moviesynopsis.data.MovieDataSource
import me.dio.bootcamp.android.moviesynopsis.domain.Movie

class MovieDataSourceImplementation(
    private val movieRestApiTask: MovieRestApiTask
) : MovieDataSource {

    companion object {
        const val TAG = "MovieRepository"
    }

    private val movieList = arrayListOf<Movie>()

    override fun getAllMovies(): List<Movie> {
        val request = movieRestApiTask.restApi().getAllMovies().execute()

        if (request.isSuccessful) {
            request.body()?.let {
                movieList.addAll(it)
            }
        } else {
            request.errorBody()?.let {
                Log.d(TAG, it.toString())
            }
        }
        return movieList
    }
}