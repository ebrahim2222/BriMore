package com.example.brikotlin.ui.onboarding

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.brikotlin.ui.login.LoginFragment
import com.example.brikotlin.ui.signup.SignUpFragment

class OnBoardingAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    val fragment = arrayOf(SignUpFragment(),LoginFragment())
    override fun getCount(): Int {
        return fragment.size
    }

    override fun getItem(position: Int): Fragment {
        return fragment[position]

    }
}