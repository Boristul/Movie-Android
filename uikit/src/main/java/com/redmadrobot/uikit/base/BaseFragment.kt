package com.redmadrobot.uikit.base

import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.Fragment

abstract class BaseFragment(resourceLayout: Int) : Fragment(resourceLayout) {

    fun showMessage(text: String): Unit = Toast.makeText(requireContext(), text, Toast.LENGTH_LONG).show()

    fun hideKeyboard() {
        val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
        imm?.hideSoftInputFromWindow(view?.windowToken, 0)
    }
}
