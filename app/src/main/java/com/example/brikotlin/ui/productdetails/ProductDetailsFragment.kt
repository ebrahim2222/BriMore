package com.example.brikotlin.ui.productdetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.brikotlin.R
import com.example.brikotlin.databinding.FragmentProductDetailsBinding
import com.example.brikotlin.domain.model.main.dynamicsectionone.DynamicSectionVariant
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class ProductDetailsFragment : Fragment() {
    lateinit var navController:NavController
    val productDetailsViewModel:ProductDetailsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentProductDetailsBinding.inflate(inflater)
        val view = binding.root

        val data = arguments?.getParcelable<DynamicSectionVariant>("productsData")

        binding.model = data

        binding.logout.setOnClickListener {
            lifecycleScope.launchWhenStarted {
                productDetailsViewModel.saveDefaultUserEmail("")
                productDetailsViewModel.saveDefaultUserPass("")
                navController.navigate(R.id.action_productDetailsFragment_to_onBoardingFragment)
            }
        }

        binding.productDetailsBack.setOnClickListener {
            navController.popBackStack()
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
    }

}