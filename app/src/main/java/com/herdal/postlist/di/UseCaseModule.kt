package com.herdal.postlist.di

import com.herdal.postlist.domain.repository.CommentRepository
import com.herdal.postlist.domain.repository.PostRepository
import com.herdal.postlist.domain.repository.UserRepository
import com.herdal.postlist.domain.use_case.comment.CommentUseCases
import com.herdal.postlist.domain.use_case.comment.GetPostCommentsUseCase
import com.herdal.postlist.domain.use_case.post.GetAllPostsUseCase
import com.herdal.postlist.domain.use_case.post.GetPostByIdUseCase
import com.herdal.postlist.domain.use_case.post.GetUserPostsUseCase
import com.herdal.postlist.domain.use_case.post.PostUseCases
import com.herdal.postlist.domain.use_case.user.GetUserByIdUseCase
import com.herdal.postlist.domain.use_case.user.UserUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun providePostUseCases(repository: PostRepository): PostUseCases =
        PostUseCases(
            getAllPostsUseCase = GetAllPostsUseCase(repository),
            getPostByIdUseCase = GetPostByIdUseCase(repository),
            getUserPostsUseCase = GetUserPostsUseCase(repository)
        )

    @Provides
    @Singleton
    fun provideCommentUseCases(repository: CommentRepository): CommentUseCases =
        CommentUseCases(
            getPostCommentsUseCase = GetPostCommentsUseCase(repository)
        )

    @Provides
    @Singleton
    fun provideUserUseCases(repository: UserRepository): UserUseCases =
        UserUseCases(
            getUserByIdUseCase = GetUserByIdUseCase(repository)
        )
}