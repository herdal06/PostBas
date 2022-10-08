package com.herdal.postlist.presentation.user_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.herdal.postlist.data.remote.model.user.User
import com.herdal.postlist.databinding.FragmentUserDetailsBinding
import com.herdal.postlist.util.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UserDetailsFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentUserDetailsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val viewModel: UserDetailsViewModel by viewModels()
    private val navigationArgs: UserDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getUserById()
        collectUser()
    }

    private fun setupUI(user: User) = binding.apply {
        tvUsernameDetails.text = user.username
        tvUserDetailsFullName.text = user.firstName + " " + user.lastName
        tvUserMail.text = user.email
        tvUserPhone.text = user.phone
        tvBirthDate.text = user.birthDate
        tvAddress.text = user.address.address
    }

    private fun collectUser() = lifecycleScope.launch {
        binding.apply {
            viewModel.user.collect {
                when (it) {
                    is Resource.Loading -> {
                        binding.loadingBarUserDetails.visibility = View.VISIBLE
                        binding.tvErrorMessageUserDetails.visibility = View.GONE
                    }
                    is Resource.Success -> {
                        it.data.let { user ->
                            setupUI(user)
                        }
                        binding.loadingBarUserDetails.visibility = View.GONE
                        binding.tvErrorMessageUserDetails.visibility = View.GONE
                    }
                    is Resource.Error -> {
                        binding.loadingBarUserDetails.visibility = View.GONE
                        binding.tvErrorMessageUserDetails.visibility = View.VISIBLE
                    }
                }
            }
        }
    }

    private fun getUserById() {
        viewModel.getUserById(getUserId())
    }

    private fun getUserId(): Int = navigationArgs.userId

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}