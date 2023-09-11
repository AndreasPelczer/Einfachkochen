package com.example.einfachkochen

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import com.example.einfachkochen.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private val viewModel: FactsViewModel by viewModels()
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerViewRV.setHasFixedSize(true)
        viewModel.factsDataList.observe(viewLifecycleOwner) {facts->
            Log.d("Homefragment","$facts")
            binding.recyclerViewRV.adapter = Adapter(viewModel,facts, NavController(requireContext())
            )
        }
    }
}











