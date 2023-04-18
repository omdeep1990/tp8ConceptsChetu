package com.chetu.demotp8.navGraph

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.chetu.demotp8.R
import com.chetu.demotp8.databinding.FragmentLoginReceiveDataBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class LoginReceiveDataFragment : Fragment() {
    private lateinit var binding : FragmentLoginReceiveDataBinding
    private val args : LoginReceiveDataFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login_receive_data, container, false)

        val user : User = Gson().fromJson(args.user, object : TypeToken<User?>(){}.type)

        binding.username.setText(user.email)
        binding.password.setText(user.password)

        binding.signUpBtn.setOnClickListener {
            it.findNavController().navigate(R.id.registration)
        }

        return binding.root
    }
}