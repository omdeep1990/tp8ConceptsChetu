package com.chetu.demotp8.navGraph

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.chetu.demotp8.R
import com.chetu.demotp8.databinding.FragmentRegisterBinding
import com.google.gson.Gson

class RegisterFragment : Fragment() {
    private lateinit var binding : FragmentRegisterBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false)

        binding.signUpBtn.setOnClickListener {
            val username = binding.username.text.toString()
            val password = binding.password.text.toString()

            /*Sending data using nav graph sage arguments*/
            val action = RegisterFragmentDirections.actionRegistrationToDetails(Gson().toJson(User(username, password)))
//            requireView().findNavController().navigate(action) /*Or*/
            it.findNavController().navigate(action)
        }
        return binding.root
    }
}