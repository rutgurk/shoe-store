package com.udacity.shoestore.screens.shoeoverview

import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.onNavDestinationSelected
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ItemShoeBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.screens.login.LoginFragmentDirections


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
        sharedViewModel.shoeList.observe(viewLifecycleOwner) {
            populateShoeList(it)
        }

        binding.floatingActionButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_shoeListFragment_to_shoeDetailFragment)
        }
        binding.lifecycleOwner = viewLifecycleOwner
        addMenuToToolbar()
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

    private fun getCard(shoe: Shoe): LinearLayout {
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
        return ViewGroup.MarginLayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }

    private fun addMenuToToolbar() {

        val menuHost = requireActivity() as MenuHost
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.overflow_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return if (menuItem.itemId == R.id.loginFragment) {
                    requireView().findNavController()
                        .navigate(ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment())
                    true
                } else {
                    false // Todo: back nav not working, fix it :)
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }
}
