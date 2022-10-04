package com.herdal.postlist.presentation.post_details

import androidx.lifecycle.ViewModel
import com.herdal.postlist.domain.use_case.comment.CommentUseCases
import com.herdal.postlist.domain.use_case.post.PostUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PostDetailsViewModel @Inject constructor(
    private val postUseCases: PostUseCases,
    private val commentUseCases: CommentUseCases
) : ViewModel() {
}