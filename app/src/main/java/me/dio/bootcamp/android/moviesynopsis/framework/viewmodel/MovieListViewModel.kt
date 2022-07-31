package me.dio.bootcamp.android.moviesynopsis.framework.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import me.dio.bootcamp.android.moviesynopsis.framework.api.MovieRestApiTask
import me.dio.bootcamp.android.moviesynopsis.data.MovieRepository
import me.dio.bootcamp.android.moviesynopsis.domain.Movie
import me.dio.bootcamp.android.moviesynopsis.implementation.MovieDataSourceImplementation
import me.dio.bootcamp.android.moviesynopsis.usecase.MoviesListUseCase

class MovieListViewModel: ViewModel() {

    companion object {
        const val TAG = "MovieListViewModel"
    }

    private val movieRestApiTask = MovieRestApiTask()
    private val movieDataSource = MovieDataSourceImplementation(movieRestApiTask)
    private val movieRepository = MovieRepository(movieDataSource)
    private val moviesListUseCase = MoviesListUseCase(movieRepository)

    private var _moviesList = MutableLiveData<List<Movie>>()
    val moviesList: LiveData<List<Movie>>
    get() = _moviesList

    fun init() {
        getAllMovies()
    }

    private fun getAllMovies() {
        Thread {
            try {
                _moviesList.postValue(moviesListUseCase.invoke())
            } catch (ex: Exception) {
                Log.d(TAG, ex.message.toString())
            }
        }.start()
    }
}