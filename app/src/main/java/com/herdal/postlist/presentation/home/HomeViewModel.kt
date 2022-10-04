package com.herdal.postlist.presentation.home

import androidx.lifecycle.ViewModel
import com.herdal.postlist.domain.use_case.post.PostUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val postUseCases: PostUseCases
) : ViewModel() {
}