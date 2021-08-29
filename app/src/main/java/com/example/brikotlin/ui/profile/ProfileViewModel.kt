package com.example.brikotlin.ui.profile

import androidx.lifecycle.ViewModel
import com.example.brikotlin.domain.model.loginresponse.UserData
import com.example.brikotlin.domain.usecase.UserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(val userUseCase: UserUseCase) : ViewModel() {

    suspend fun getUserData(): Flow<String?> {
        return userUseCase.getUser()
    }

}