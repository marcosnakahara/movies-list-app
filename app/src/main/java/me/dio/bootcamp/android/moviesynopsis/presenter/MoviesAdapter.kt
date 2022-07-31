package me.dio.bootcamp.android.moviesynopsis.presenter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import kotlinx.android.synthetic.main.movie_item_layout.view.*
import me.dio.bootcamp.android.moviesynopsis.R
import me.dio.bootcamp.android.moviesynopsis.domain.Movie

class MoviesAdapter(
    private val moviesList: List<Movie>

): RecyclerView.Adapter<MoviesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item_layout, parent, false)
        return MoviesViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.itemView.apply {
            tv_movieTitle.text = moviesList[position].titulo
            tv_description.text = moviesList[position].descricao
            tv_launchDate.text = moviesList[position].dataLancamento
            iv_image.load(moviesList[position].imagem) {
                placeholder(R.drawable.ic_image)
                fallback(R.drawable.ic_image)
            }
        }
    }

    override fun getItemCount(): Int = moviesList.size
}