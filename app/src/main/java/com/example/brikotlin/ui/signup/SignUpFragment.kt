package com.example.brikotlin.ui.signup

import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.brikotlin.R
import com.example.brikotlin.databinding.FragmentSignUpBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SignUpFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentSignUpBinding.inflate(inflater)
        val view = binding.root

        val text:String = "By creating an account, you agree to our Terms of Service and Privacy Policy"
        val spannableStringBuilder = SpannableStringBuilder(text)

        val clickableSpan = object : ClickableSpan(){
            override fun onClick(widget: View) {
                Toast.makeText(requireContext(),"Clicked",Toast.LENGTH_LONG).show()
            }

            override fun updateDrawState(ds: TextPaint) {
                ds.color = ContextCompat.getColor(requireContext(),R.color.spannable)
                ds.isUnderlineText  = false
            }
        }
        val clickableSpan2 = object : ClickableSpan(){
            override fun onClick(widget: View) {
                //Toast.makeText(requireContext(),"Clicked",Toast.LENGTH_LONG).show()
            }

            override fun updateDrawState(ds: TextPaint) {
                ds.color = ContextCompat.getColor(requireContext(),R.color.spannable)
                ds.isUnderlineText  = false
            }
        }
        spannableStringBuilder.setSpan(clickableSpan,40,57,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableStringBuilder.setSpan(clickableSpan2,62,76,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        binding.signupPrivacy.text = spannableStringBuilder
        binding.signupPrivacy.movementMethod = LinkMovementMethod.getInstance()

        return view
    }


}