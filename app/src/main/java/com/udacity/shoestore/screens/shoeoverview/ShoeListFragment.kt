package com.udacity.shoestore.screens.shoeoverview

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.ShoeViewModel
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ItemShoeBinding
import com.udacity.shoestore.models.Shoe


class ShoeListFragment : Fragment() {

    private val sharedViewModel: ShoeViewModel by activityViewModels()

    private lateinit var binding: FragmentShoeListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_list, container, false
        )
//        sharedViewModel.addShoe(Shoe("Freak", 15.0, "Nike", "Mooie schoen"))
        sharedViewModel.shoeList.observe(viewLifecycleOwner) {
            populateShoeList(it)
        }
//        sharedViewModel.addShoe(Shoe("Freak 2", 15.0, "Nike", "Mooie schoen"))

        binding.floatingActionButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_shoeListFragment_to_shoeDetailFragment)
        }
        return binding.root
    }

    private fun populateShoeList(shoeList: List<Shoe>) {
        if (shoeList.isNotEmpty()) {
            binding.shoeListContainer.removeAllViewsInLayout()
            for (shoe in shoeList) {
                binding.shoeListContainer.addView(getCard(shoe), getParams())
            }
        }
    }

    private fun getCard(shoe: Shoe) : LinearLayout {
        val container = LinearLayout(context)
        val shoeBinding = DataBindingUtil.inflate<ItemShoeBinding>(
            layoutInflater, R.layout.item_shoe, container, true
        )
        shoeBinding.shoeName.text = shoe.name
        shoeBinding.shoeSize.text = shoe.size.toString()
        shoeBinding.shoeCompany.text = shoe.company
        shoeBinding.shoeDescription.text = shoe.description
        return container
    }

    private fun getParams(): ViewGroup.MarginLayoutParams {
        var params =  ViewGroup.MarginLayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        return params
    }
}