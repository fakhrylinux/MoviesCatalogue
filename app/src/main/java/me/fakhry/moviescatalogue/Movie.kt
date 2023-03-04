package me.fakhry.moviescatalogue

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    val title: String,
    val description: String,
    val photo: Int,
    val poster: Int
) : Parcelable