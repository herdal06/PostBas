package com.herdal.postlist.di

import com.herdal.postlist.data.remote.ApiService
import com.herdal.postlist.data.repository.CommentRepositoryImpl
import com.herdal.postlist.data.repository.PostRepositoryImpl
import com.herdal.postlist.data.repository.UserRepositoryImpl
import com.herdal.postlist.domain.repository.CommentRepository
import com.herdal.postlist.domain.repository.PostRepository
import com.herdal.postlist.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun providePostRepository(apiService: ApiService): PostRepository =
        PostRepositoryImpl(apiService)

    @Provides
    @Singleton
    fun provideCommentRepository(apiService: ApiService): CommentRepository =
        CommentRepositoryImpl(apiService)

    @Provides
    @Singleton
    fun provideUserRepository(apiService: ApiService): UserRepository =
        UserRepositoryImpl(apiService)
}