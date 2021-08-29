package com.example.brikotlin.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.brikotlin.R
import com.example.brikotlin.databinding.FragmentProfileBinding
import com.example.brikotlin.domain.model.loginresponse.UserData
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ProfileFragment : Fragment() {

    lateinit var binding:FragmentProfileBinding
    lateinit var navController: NavController
    val profileViewModel:ProfileViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater)
        val view = binding.root
        lifecycleScope.launchWhenStarted {
            val userData = profileViewModel.getUserData()
            userData.asLiveData().observe(requireActivity(), Observer {
                val gson = Gson()
                val data = gson.fromJson(it , UserData::class.java)
                binding.model = data!!

            })

        }
        return view
    }


}