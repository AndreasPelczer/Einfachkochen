package com.example.einfachkochen.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.einfachkochen.R
import com.example.einfachkochen.databinding.FragmentHomeBinding
import com.example.einfachkochen.databinding.FragmentRezeptListeBinding
import com.example.einfachkochen.databinding.ItemRezeptBinding


class RezeptListeFragment : Fragment() {

    private var _binding: FragmentRezeptListeBinding? = null
    private val binding get() = _binding!!
    val layoutManager: LinearLayoutManager = LinearLayoutManager(context)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rezept_liste, container, false)
    }


}