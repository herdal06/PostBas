package com.herdal.postlist.presentation.post_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.herdal.postlist.data.remote.model.comment.CommentResponse
import com.herdal.postlist.data.remote.model.post.Post
import com.herdal.postlist.domain.use_case.comment.CommentUseCases
import com.herdal.postlist.domain.use_case.post.PostUseCases
import com.herdal.postlist.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostDetailsViewModel @Inject constructor(
    private val postUseCases: PostUseCases,
    private val commentUseCases: CommentUseCases
) : ViewModel() {

    private val _post = MutableStateFlow<Resource<Post>>(Resource.Loading)
    val post: StateFlow<Resource<Post>> = _post

    private val _allComments = MutableStateFlow<Resource<CommentResponse>>(Resource.Loading)
    val allComments: StateFlow<Resource<CommentResponse>> = _allComments

    fun getPostById(id: Int) = viewModelScope.launch {
        postUseCases.getPostByIdUseCase.invoke(id).catch {
        }.collect {
            _post.value = it
        }
    }

    fun getAllPostComments(id: Int) {
        commentUseCases.getPostCommentsUseCase.invoke(id, 10, 0).onEach { res ->
            when (res) {
                is Resource.Success -> {
                    _allComments.value = res
                }
                is Resource.Loading -> {
                    _allComments.value = res
                }
                is Resource.Error -> {
                    _allComments.value = res
                }
            }
        }.launchIn(viewModelScope)
    }
}
