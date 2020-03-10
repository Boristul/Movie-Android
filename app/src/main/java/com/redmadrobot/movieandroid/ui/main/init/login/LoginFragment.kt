package com.redmadrobot.movieandroid.ui.main.init.login

import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.redmadrobot.movieandroid.R
import com.redmadrobot.movieandroid.databinding.FragmentLoginBinding

class LoginFragment : Fragment(R.layout.fragment_login) {
    private var _binding: FragmentLoginBinding? = null
    private val binding: FragmentLoginBinding get() = checkNotNull(_binding)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val viewModel by viewModels<LoginFragmentViewModel>()
        _binding = FragmentLoginBinding.bind(view)

        binding.editLogin.run {
            addTextChangedListener { viewModel.updateLogin(it.toString()) }
        }

        binding.editPassword.run {
            addTextChangedListener { viewModel.updatePassword(it.toString()) }
        }

        binding.loginButton.run {
            viewModel.isDataEntered.observe(viewLifecycleOwner) { isEnabled = it }
            setOnClickListener { viewModel.login() }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
