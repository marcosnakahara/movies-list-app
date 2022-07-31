package me.dio.bootcamp.android.moviesynopsis.presenter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*
import me.dio.bootcamp.android.moviesynopsis.R
import me.dio.bootcamp.android.moviesynopsis.domain.Movie
import me.dio.bootcamp.android.moviesynopsis.framework.viewmodel.MovieListViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var movieListViewModel: MovieListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        movieListViewModel = ViewModelProvider.NewInstanceFactory().create(MovieListViewModel::class.java)
        movieListViewModel.init()
        initObserver()
        loadingVisibility(true)
    }

    private fun initObserver() {
        movieListViewModel.moviesList.observe(this) { list ->
            if (list.isNotEmpty()) {
                populateList(list)
                loadingVisibility(false)
            }
        }
    }

    private fun populateList(list: List<Movie>) {
        rv_moviesList.apply {
            hasFixedSize()
            adapter = MoviesAdapter(list)
        }
    }

    private fun loadingVisibility(isLoading: Boolean) {
        pb_progress.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
}