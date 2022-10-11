package com.herdal.postlist.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.herdal.postlist.data.remote.model.post.PostResponse
import com.herdal.postlist.domain.use_case.post.PostUseCases
import com.herdal.postlist.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val postUseCases: PostUseCases
) : ViewModel() {

    private val _allPosts = MutableStateFlow<Resource<PostResponse>>(Resource.Loading)
    val allPosts: StateFlow<Resource<PostResponse>> = _allPosts

    init {
        getAllPosts()
    }

    private fun getAllPosts() {
        postUseCases.getAllPostsUseCase(20, 0).onEach { res ->
            when (res) {
                is Resource.Success -> {
                    _allPosts.value = res
                }
                is Resource.Loading -> {
                    _allPosts.value = res
                }
                is Resource.Error -> {
                    _allPosts.value = res
                }
            }
        }.launchIn(viewModelScope)
    }
}