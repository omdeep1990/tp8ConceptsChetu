package com.chetu.demotp8.fragments.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chetu.demotp8.R
import com.chetu.demotp8.databinding.FragmentSignUpBinding

class FragmentSignUp : Fragment(), TextWatcher {
    private lateinit var binding : FragmentSignUpBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignUpBinding.inflate(layoutInflater, container, false)

        binding.username.addTextChangedListener(this)
        binding.password.addTextChangedListener(this)
        binding.confirmPassword.addTextChangedListener(this)
        return binding.root
    }
    private fun validateData() : Boolean {
        if (binding.username.text.toString().isEmpty()) {
            binding.username.error = "Invalid Username"
            binding.username.requestFocus()
            return false
        } else if (binding.username.text.toString().contains(" ".toRegex())) {
            binding.username.error = "No Space Allowed"
            binding.username.requestFocus()
            return false
        }
        if (!binding.password.text.toString().matches("^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#\$%^&+=!])(?=\\\\S+\$).{4,}\$".toRegex())) {
            binding.password.error = "Password Must be Strong"
            binding.password.requestFocus()
            return false
        } else if (binding.password.text.toString().contains(" ")) {
            binding.password.error = "No Space Allowed"
            binding.password.requestFocus()
            return false
        }
        if (binding.confirmPassword.text.toString() != binding.password.text.toString()) {
            binding.password.error = "Password & Confirm Password are not same."
            binding.password.requestFocus()
            return false
        }
        return true
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//        binding.signUpBtn.isEnabled = validateData()
    }

    override fun onTextChanged(charSequence : CharSequence?, p1: Int, p2: Int, p3: Int) {
        binding.signUpBtn.isEnabled = validateData()
    }

    override fun afterTextChanged(p0: Editable?) {

    }
}