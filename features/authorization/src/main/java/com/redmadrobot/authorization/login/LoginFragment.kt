package com.redmadrobot.authorization.login

import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import com.redmadrobot.authorization.R
import com.redmadrobot.authorization.databinding.FragmentLoginBinding
import com.redmadrobot.uikit.base.BaseFragment

class LoginFragment : BaseFragment(R.layout.fragment_login) {
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
            viewModel.isDataValid.observe(viewLifecycleOwner) { isEnabled = it }
            setOnClickListener { viewModel.login() }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
