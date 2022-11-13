package com.udacity.shoestore.screens.shoeoverview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout.LayoutParams
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.setMargins
import androidx.core.view.updateMargins
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.google.android.material.card.MaterialCardView
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding


class ShoeListFragment : Fragment() {

    private lateinit var binding: FragmentShoeListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_list, container, false
        )
        return binding.root
    }

    private fun getCard(name: String) : LinearLayout {
        var container = LinearLayout(context)
        val shoeItem = View.inflate(context, R.layout.item_shoe, container)
        shoeItem.findViewById<TextView>(R.id.shoe_name).text = name
        return container
    }

    private fun getParams(): ViewGroup.MarginLayoutParams {
        var params =  ViewGroup.MarginLayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        return params
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.shoeListContainer.addView(getCard("Freak 1"), getParams())
        binding.shoeListContainer.addView(getCard("Freak 2"))
        binding.shoeListContainer.addView(getCard("Freak 3"))
        binding.shoeListContainer.addView(getCard("Freak 4"))
        binding.shoeListContainer.addView(getCard("Freak 5"))
        binding.shoeListContainer.addView(getCard("Freak 6"))
        binding.shoeListContainer.addView(getCard("Freak 7"))
        binding.shoeListContainer.addView(getCard("Freak 8"))
        binding.shoeListContainer.addView(getCard("Freak 9"))
    }
}