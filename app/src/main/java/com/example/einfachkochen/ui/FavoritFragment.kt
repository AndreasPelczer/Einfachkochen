package com.example.einfachkochen.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.einfachkochen.FactsViewModel
import com.example.einfachkochen.FavoritenAdapter
import com.example.einfachkochen.databinding.FragmentFavoritBinding

class FavoritFragment : Fragment() {

    private val viewModel: FactsViewModel by viewModels()
    private lateinit var binding: FragmentFavoritBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel.loadLiked()
        binding=FragmentFavoritBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerViewFavoritenRV.setHasFixedSize(true)

        viewModel.likedDataList.observe(viewLifecycleOwner){
            binding.recyclerViewFavoritenRV.adapter= FavoritenAdapter(viewModel,it)
        }
    }


}