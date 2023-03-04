package me.fakhry.moviescatalogue

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import me.fakhry.moviescatalogue.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        list.addAll(getListMovies())
        showRecyclerList()
    }

    private fun getListMovies(): ArrayList<Movie> {
        val dataTitle = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataPoster = resources.obtainTypedArray(R.array.data_poster)
        val listMovies = ArrayList<Movie>()
        for (i in dataTitle.indices) {
            val movie = Movie(
                title = dataTitle[i],
                description = dataDescription[i],
                photo = dataPhoto.getResourceId(i, -1),
                poster = dataPoster.getResourceId(i, -1)
            )
            listMovies.add(movie)
        }
        dataPhoto.recycle()
        dataPoster.recycle()
        return listMovies
    }

    private fun showRecyclerList() {
        binding.rvMovies.layoutManager = LinearLayoutManager(this)
        val movieAdapter = MovieAdapter(list)
        binding.rvMovies.adapter = movieAdapter

        movieAdapter.setOnItemClickCallback(object : MovieAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Movie) {
                showSelectedMovie(data)
            }
        })
    }

    private fun showSelectedMovie(movie: Movie) {
        val intent = Intent(this@MainActivity, MovieDetailActivity::class.java)
        intent.putExtra(MovieDetailActivity.EXTRA_MOVIE, movie)
        startActivity(intent)
    }
}