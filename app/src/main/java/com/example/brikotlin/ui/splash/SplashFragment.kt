package com.example.brikotlin.ui.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.brikotlin.R
import com.example.brikotlin.databinding.FragmentSplashBinding
import com.example.brikotlin.utils.ResponseError
import com.example.brikotlin.utils.Status
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking

@AndroidEntryPoint
class SplashFragment : Fragment() {


    val splashViewModel:SplashViewModel by viewModels()
    lateinit var navController:NavController
    private  val TAG = "SplashFragment"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding:FragmentSplashBinding = FragmentSplashBinding.inflate(inflater);
        val view = binding.root
        Handler(Looper.getMainLooper()).postDelayed({
            navController.navigate(R.id.action_splashFragment_to_onBoardingFragment)
/*
            lifecycleScope.launchWhenStarted {
            val userEmail = splashViewModel.getUserEmail()
            val userPassword = splashViewModel.getUserPassword()
            if(userEmail == "" && userPassword == ""){
                navController.navigate(R.id.action_splashFragment_to_onBoardingFragment)
            }else{
                Log.d(TAG, "onCreateView: "+userEmail +userPassword)

                splashViewModel.login(userEmail!!,userPassword!!)
                splashViewModel.mutableStateFlow.collect {
                        when(it.status){
                            Status.SUCCESS -> {
                                navController.navigate(R.id.action_splashFragment_to_mainFragment)
                                splashViewModel.saveToken(it.data!!.data.apiToken)
                            }
                            Status.ERROR -> {
                                ResponseError.errorCode(requireContext(),it.code!!)

                            }
                        }
                    }
                }

            }

 */

        },3000)





        return view;
    }
}