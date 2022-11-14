package com.udacity.shoestore.screens.shoeoverview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.udacity.shoestore.R
import com.udacity.shoestore.ShoeViewModel
import com.udacity.shoestore.databinding.FragmentShoeListBinding
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
        sharedViewModel.addShoe(Shoe("Freak", 15.0, "Nike", "Mooie schoen"))
        sharedViewModel.shoeList.observe(viewLifecycleOwner) {
            populateShoeList(it)
        }
        sharedViewModel.addShoe(Shoe("Freak 2", 15.0, "Nike", "Mooie schoen"))
        return binding.root
    }

    private fun populateShoeList(shoeList: List<Shoe>) {
        for (shoe in shoeList) {
            binding.shoeListContainer.addView(getCard(shoe), getParams())
        }
    }

    private fun getCard(shoe: Shoe) : LinearLayout {
        var container = LinearLayout(context)
        val shoeItem = View.inflate(context, R.layout.item_shoe, container)
        shoeItem.findViewById<TextView>(R.id.shoe_name).text = shoe.name
        shoeItem.findViewById<TextView>(R.id.shoe_size).text = shoe.size.toString()
        shoeItem.findViewById<TextView>(R.id.shoe_company).text = shoe.company
        shoeItem.findViewById<TextView>(R.id.shoe_description).text = shoe.description
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