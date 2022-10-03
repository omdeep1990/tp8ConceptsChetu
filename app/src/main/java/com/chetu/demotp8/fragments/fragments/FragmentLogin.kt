package com.chetu.demotp8.fragments.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.chetu.demotp8.databinding.FragmentLoginBinding

class FragmentLogin : Fragment() {
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(layoutInflater, container, false)

//        binding.username.addTextChangedListener(object : TextWatcher {
//            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
//
//            }
//            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
//                binding.loginBtn.isEnabled = validateUsername()
//            }
//            override fun afterTextChanged(editable: Editable) {
//
//            }
//        })
//
//        binding.password.addTextChangedListener(object : TextWatcher {
//            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//            }
//
//            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                binding.loginBtn.isEnabled = validatePassword()
//            }
//
//            override fun afterTextChanged(p0: Editable?) {
//            }
//
//        })


        //TODO: Testing Code: -
        val textWatcher: TextWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                // get the content of both the edit text
                val emailInput: String = binding.username.text.toString()
                val passwordInput: String = binding.password.text.toString()

                // check whether both the fields are empty or not
//                binding.loginBtn.isEnabled = validateUsername() && validatePassword()
//                binding.loginBtn.isEnabled = validatePassword()

            }

            override fun afterTextChanged(s: Editable) {}
        }

        binding.username.addTextChangedListener(textWatcher)
        binding.password.addTextChangedListener(textWatcher)

        return binding.root
    }
    private fun validateUsername() : Boolean {
        if (binding.username.text.toString().isEmpty()) {
            binding.username.error = "Invalid Username"
            binding.username.requestFocus()
            return false
        } else if (binding.username.text.toString().contains(" ".toRegex())) {
            binding.username.error = "No Space Allowed"
            binding.username.requestFocus()
            return false
        }
        return true
    }

    private fun validatePassword() : Boolean {
        if (!binding.password.text.toString().matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#\$%^&+=])(?=\\S+\$).{8,}\$".toRegex())) {
            binding.password.error = "Password Must be Strong"
            binding.password.requestFocus()
            return false
        } else if (binding.password.text.toString().contains(" ")) {
            binding.password.error = "No Space Allowed"
            binding.password.requestFocus()
            return false
        }
        return true
    }
}