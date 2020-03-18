package com.redmadrobot.authorization.ui.login

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import com.redmadrobot.authorization.R
import com.redmadrobot.authorization.databinding.FragmentLoginBinding
import com.redmadrobot.authorization.di.component.LoginComponent
import com.redmadrobot.core.ui.BaseFragment
import javax.inject.Inject
import javax.inject.Provider

class LoginFragment : BaseFragment(R.layout.fragment_login) {

    private var _binding: FragmentLoginBinding? = null
    private val binding: FragmentLoginBinding get() = checkNotNull(_binding)

    @Inject
    lateinit var viewModelFactory: Provider<LoginFragmentViewModel>
    private val viewModel by lazy { viewModelFactory.get() }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        LoginComponent.Builder
            .build()
            .inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        LoginComponent.Builder.build()

        _binding = FragmentLoginBinding.bind(view)

        binding.editLogin.run {
            addTextChangedListener { viewModel.updateLogin(it.toString()) }
        }

        binding.editPassword.run {
            addTextChangedListener { viewModel.updatePassword(it.toString()) }
        }

        binding.loginButton.run {
            viewModel.isDataValid.observe(viewLifecycleOwner) { isEnabled = it }
            setOnClickListener { viewModel.loginButtonClicked() }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
