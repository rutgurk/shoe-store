package com.udacity.shoestore.screens.shoeoverview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe

class ShoeDetailFragment: Fragment() {

    private lateinit var binding: FragmentShoeDetailBinding
    private val sharedViewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_detail, container, false
        )
        binding.shoeViewModel = sharedViewModel
        binding.saveButton.setOnClickListener {
            // Todo: replace this add shoe method
            sharedViewModel.createShoeFromInput()
            it.findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
        }
        binding.cancelButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
        }
        return binding.root
    }

}