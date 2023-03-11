package me.fakhry.moviescatalogue

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import me.fakhry.moviescatalogue.databinding.ItemRowMovieBinding

class MovieAdapter(private val listMovie: ArrayList<Movie>) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemRowMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val (title, description, photo) = listMovie[position]
        holder.binding.tvItemName.text = title
        holder.binding.tvItemDescription.text = description
        holder.binding.imgItemImage.setImageResource(photo)
        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, MovieDetailActivity::class.java)
            intentDetail.putExtra(
                MovieDetailActivity.EXTRA_MOVIE,
                listMovie[holder.adapterPosition]
            )
            holder.itemView.context.startActivity(intentDetail)
        }
    }

    override fun getItemCount(): Int = listMovie.size

    class ViewHolder(var binding: ItemRowMovieBinding) : RecyclerView.ViewHolder(binding.root)
}