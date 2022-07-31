package me.dio.bootcamp.android.moviesynopsis.domain

import com.google.gson.annotations.SerializedName


data class Movie(
    val id: Int,
    val titulo: String?,
    val descricao:String?,
    val imagem:String?,
    @SerializedName("data_lancamento")
    val dataLancamento:String?
)
