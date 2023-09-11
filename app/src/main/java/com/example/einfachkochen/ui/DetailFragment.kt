package com.example.einfachkochen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.einfachkochen.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {

    private val viewModel: FactsViewModel by viewModels()

    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            val id = it.getLong("id")
            viewModel.loadFactsDetail(id)

            viewModel.factsDetail.observe(viewLifecycleOwner) {
                binding.textViewFragmenTV.text= it.fact

            }
        }
        binding.cardView.setOnClickListener{
            val navController = findNavController()
            navController.navigate(DetailFragmentDirections.actionDetailFragmentToHomeFragment())
        }
    }
}