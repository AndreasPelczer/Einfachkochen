package com.example.einfachkochen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.einfachkochen.databinding.LikedItemBinding


class FavoritenAdapter(

    private val viewModel: FactsViewModel,
    private var dataset: List<FactsData>,
    // private val navController: NavController,

) : RecyclerView.Adapter<FavoritenAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: LikedItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritenAdapter.ViewHolder {
        val binding = LikedItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: FavoritenAdapter.ViewHolder, position: Int) {
        val item = dataset[position]
        holder.binding.likedTV.text = item.fact


        val likeImageResource = if (item.istLiked) R.drawable.baseline_favorite_24
        else R.drawable.baseline_favorite_border_24
        holder.binding.imageView.setImageResource(likeImageResource)

        holder.binding.imageView.setOnClickListener {
            val like = dataset[position]
            like.istLiked = !like.istLiked
            notifyItemChanged(position)

            //Datenbank updaten
            viewModel.updateLikedStatusInDb(like)
        }
    }
}






