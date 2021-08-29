package com.example.brikotlin.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.example.brikotlin.R
import com.example.brikotlin.databinding.FragmentOnBoardingBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
public class OnBoardingFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding:FragmentOnBoardingBinding = FragmentOnBoardingBinding.inflate(inflater)
        val view = binding.root
        val adapter:OnBoardingAdapter = OnBoardingAdapter(requireActivity().supportFragmentManager)
        binding.onBoardingViewpager.adapter = adapter


        return view;
    }

}