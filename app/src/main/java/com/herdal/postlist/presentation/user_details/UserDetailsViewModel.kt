package com.herdal.postlist.presentation.user_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.herdal.postlist.data.remote.model.user.User
import com.herdal.postlist.domain.use_case.user.UserUseCases
import com.herdal.postlist.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserDetailsViewModel @Inject constructor(
    private val userUseCases: UserUseCases
) : ViewModel() {
    private val _user = MutableStateFlow<Resource<User>>(Resource.Loading)
    val user: StateFlow<Resource<User>> = _user

    fun getUserById(id: Int) = viewModelScope.launch {
        userUseCases.getUserByIdUseCase.invoke(id).catch {
        }.collect {
            _user.value = it
        }
    }
}