package me.fakhry.moviescatalogue

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import coil.load
import me.fakhry.moviescatalogue.databinding.ActivityMovieDetailBinding

class MovieDetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    private lateinit var binding: ActivityMovieDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movie = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(EXTRA_MOVIE, Movie::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_MOVIE)
        }

        if (movie != null) {
            binding.ivPoster.load(movie.photo)
            binding.ivPoster2.load(movie.poster)
            binding.tvTitle.text = movie.title
            binding.tvDescription.text = movie.description
        }
    }
}