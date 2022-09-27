package com.herdal.postlist.domain.use_case.post

data class PostUseCases(
    val getAllPostsUseCase: GetAllPostsUseCase,
    val getPostByIdUseCase: GetPostByIdUseCase,
    val getUserPostsUseCase: GetUserPostsUseCase
)
