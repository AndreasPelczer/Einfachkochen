package com.example.einfachkochen.ui

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.einfachkochen.R
import com.example.einfachkochen.adapter.RezeptAdapter
import com.example.einfachkochen.data.datamodels.Rezept
import com.example.einfachkochen.databinding.FragmentHomeBinding
import com.example.einfachkochen.databinding.FragmentRezeptListeBinding
import com.example.einfachkochen.databinding.ItemRezeptBinding


class RezeptListeFragment : Fragment() {

    private var _binding: FragmentRezeptListeBinding? = null
    private val binding get() = _binding!!
    val layoutManager: LinearLayoutManager = LinearLayoutManager(context)
    private val viewModel: FirebaseViewmodel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rezept_liste, container, false)
    }
    private fun setupRecyclerView(rezeptDataList: List<Rezept>) {


        // Initialisiere den Adapter
        val rezeptAdapter = RezeptAdapter(viewModel, rezeptDataList, findNavController())

        // Verbinde den Adapter mit dem RecyclerView
        binding.rezepteRecyclerView.adapter = rezeptAdapter

        // Setze das Layout-Manager für den RecyclerView
        binding.rezepteRecyclerView.layoutManager = LinearLayoutManager(requireContext())
    }


}