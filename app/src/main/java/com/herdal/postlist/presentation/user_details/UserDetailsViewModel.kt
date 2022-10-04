package com.herdal.postlist.presentation.user_details

import androidx.lifecycle.ViewModel
import com.herdal.postlist.domain.use_case.user.UserUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserDetailsViewModel @Inject constructor(
    private val userUseCases: UserUseCases
) : ViewModel() {
}