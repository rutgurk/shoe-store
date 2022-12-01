package com.udacity.shoestore.screens.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_login, container, false
        )
        binding.loginButton.setOnClickListener {
            if (viewModel.isValidUsername()) findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
        }
        binding.registerButton.setOnClickListener {
            if (viewModel.isValidUsername()) findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
        }
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding.loginViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }
}