package com.udacity.shoestore.screens.shoeoverview

import android.os.Bundle
import android.view.*
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe

class ShoeDetailFragment : Fragment() {

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
            sharedViewModel.createShoeFromInput()
            ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment()
        }
        binding.cancelButton.setOnClickListener {
            ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment()
        }
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

}