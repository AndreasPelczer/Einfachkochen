package com.example.einfachkochen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.einfachkochen.databinding.ListItemBinding


class Adapter(

    private val viewModel: FactsViewModel,
    private var dataset: List<FactsData>,
    private val navController: NavController,

    ) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    inner class ViewHolder(val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataset[position]
        holder.binding.factTextViewTV.setText(item.fact)

        holder.binding.cardViewCV.setOnClickListener {
            holder.itemView.findNavController()
        }
        val likeImageResource = if (item.istLiked) R.drawable.baseline_favorite_24
        else R.drawable.baseline_favorite_border_24
        holder.binding.favoritenHerzIV.setImageResource(likeImageResource)

        holder.binding.favoritenHerzIV.setOnClickListener {
            val like = dataset[position]
            like.istLiked = !like.istLiked
            notifyItemChanged(position)

            //Datenbank updaten
            viewModel.updateLikedStatusInDb(like)
        }
    }
}






