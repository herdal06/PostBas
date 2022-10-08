package com.herdal.postlist.domain.use_case.user

import com.herdal.postlist.data.remote.model.user.User
import com.herdal.postlist.domain.repository.UserRepository
import com.herdal.postlist.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetUserByIdUseCase @Inject constructor(
    private val repository: UserRepository
) {
    suspend operator fun invoke(id: Int): Flow<Resource<User>> {
        return flow {
            val user = repository.getUserById(id)
            emit(Resource.Success(user))
        }.flowOn(Dispatchers.IO)
    }
}