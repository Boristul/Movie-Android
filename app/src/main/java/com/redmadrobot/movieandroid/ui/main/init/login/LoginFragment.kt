package com.redmadrobot.movieandroid.ui.main.init.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.redmadrobot.movieandroid.R
import com.redmadrobot.movieandroid.databinding.FragmentLoginBinding

class LoginFragment : Fragment(R.layout.fragment_login) {
    private var _binding: FragmentLoginBinding? = null
    val binding: FragmentLoginBinding get() = checkNotNull(_binding)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentLoginBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
