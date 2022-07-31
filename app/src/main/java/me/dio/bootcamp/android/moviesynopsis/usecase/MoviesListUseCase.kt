package me.dio.bootcamp.android.moviesynopsis.usecase

import me.dio.bootcamp.android.moviesynopsis.data.MovieRepository

class MoviesListUseCase(
    private val movieRepository: MovieRepository
) {
    operator fun invoke() = movieRepository.getAllMoviesFromDataSource()
}

