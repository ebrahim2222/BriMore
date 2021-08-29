package com.example.brikotlin.ui.login

import android.app.ProgressDialog
import android.graphics.Color
import android.os.Bundle
import android.text.*
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.brikotlin.R
import com.example.brikotlin.databinding.FragmentLoginBinding
import com.example.brikotlin.domain.model.loginresponse.UserData
import com.example.brikotlin.domain.usecase.UserUseCase
import com.example.brikotlin.utils.ResponseError
import com.example.brikotlin.utils.Status
import com.google.android.material.color.MaterialColors.getColor
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment : Fragment() {
    val TAG = "LoginFragment"
    var userData:UserData?=null
    lateinit var navController: NavController
    @Inject lateinit var userUseCase:UserUseCase
    lateinit var binding:FragmentLoginBinding
    lateinit var progressDialog:ProgressDialog

    val loginViewModel: LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater)
        val view = binding.root
        progressDialog = ProgressDialog(requireContext())
        val text:String = "Don’t have an account? Swipe right to "
        val spannableStringBuilder = SpannableStringBuilder(text)

        val clickableSpan = object : ClickableSpan(){
            override fun onClick(widget: View) {
               // Toast.makeText(requireContext(),"clicker",Toast.LENGTH_LONG).show()
            }

            override fun updateDrawState(ds: TextPaint) {
                ds.color = ContextCompat.getColor(requireContext(),R.color.spannable)
                ds.isUnderlineText = false
            }
        }
        spannableStringBuilder.append("create a new account.")
        spannableStringBuilder.setSpan(clickableSpan,37,58,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.loginPrivacy.text = spannableStringBuilder
        binding.loginPrivacy.movementMethod = LinkMovementMethod.getInstance()


        binding.loginBtn.setOnClickListener(View.OnClickListener {
            showProgressDialog()
            val email:String = binding.emailField.text.toString()
            val pass:String = binding.passwordField.text.toString()

            if(TextUtils.isEmpty(email) && TextUtils.isEmpty(pass)){
                Toast.makeText(requireContext(),"enter all data",Toast.LENGTH_SHORT).show()
                progressDialog.dismiss()

            }else{
                loadUserData(email,pass)

            }


        })

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
    }

    private fun loadUserData(email: String, pass: String) {
        loginViewModel.login(email, pass)
        lifecycleScope.launchWhenStarted {
            loginViewModel.mutableStateFlow.collect {
                when (it.status) {
                    Status.SUCCESS -> {
                        Toast.makeText(requireContext(), "success", Toast.LENGTH_LONG).show()
                        userData = it.data!!.data
                        loginViewModel.saveUserToken(userData!!.apiToken)
                        loginViewModel.saveUserData(userData!!)
                        loginViewModel.saveUserEmail(email)
                        loginViewModel.saveUserPass(pass)

                        progressDialog.dismiss()
                        navController.navigate(R.id.action_onBoardingFragment_to_mainFragment)

                    }
                    Status.ERROR -> {
                        ResponseError.errorCode(requireContext(), it.code!!)
                        progressDialog.dismiss()

                    }
                }
            }
        }
    }

    fun showProgressDialog(){
        progressDialog.setTitle("please wait")
        progressDialog.setMessage("Loading")
        progressDialog.show()
        progressDialog.setCanceledOnTouchOutside(false)

    }
}