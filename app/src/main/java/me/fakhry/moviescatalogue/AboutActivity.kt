package me.fakhry.moviescatalogue

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import coil.load
import me.fakhry.moviescatalogue.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAboutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "About Me"

        binding.ivPhoto.load(getString(R.string.photo_url))
        binding.tvName.text = getString(R.string.my_name)
        binding.tvEmail.text = getString(R.string.my_email)
    }
}