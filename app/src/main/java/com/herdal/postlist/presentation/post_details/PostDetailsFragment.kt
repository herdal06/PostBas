package com.herdal.postlist.presentation.post_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.herdal.postlist.data.remote.model.post.Post
import com.herdal.postlist.data.remote.model.user.User
import com.herdal.postlist.databinding.FragmentPostDetailsBinding
import com.herdal.postlist.presentation.post_details.adapter.PostCommentAdapter
import com.herdal.postlist.util.Resource
import com.herdal.postlist.util.extensions.loadImage
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PostDetailsFragment : Fragment() {

    private var _binding: FragmentPostDetailsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val viewModel: PostDetailsViewModel by viewModels()
    private val navigationArgs: PostDetailsFragmentArgs by navArgs()
    private val postCommentAdapter: PostCommentAdapter by lazy {
        PostCommentAdapter(::navigateToUserDetails)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPostDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun getPostId(): Int = navigationArgs.postId

    private fun getUserId(): Int = navigationArgs.userId

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.bindAdapter(postCommentAdapter = postCommentAdapter)
        collectComments()
        collectPost()
        collectUser()
        manageUI()
        getPostById()
        getUserById()
        getAllPostComments()
    }

    private fun getUserById() {
        viewModel.getUserById(getUserId())
    }

    private fun collectPost() = lifecycleScope.launch {
        viewModel.post.collect {
            when (it) {
                is Resource.Loading -> {
                    binding.loadingBarPostDetails.visibility = View.VISIBLE
                    binding.tvErrorMessagePostDetails.visibility = View.GONE
                }
                is Resource.Success -> {
                    it.data.let { post ->
                        showUserDetailsOnClickUser(it.data.userId)
                        makePostVisible()
                        setupUI(post)
                    }
                    binding.loadingBarPostDetails.visibility = View.GONE
                    binding.tvErrorMessagePostDetails.visibility = View.GONE
                }
                is Resource.Error -> {
                    binding.loadingBarPostDetails.visibility = View.GONE
                    binding.tvErrorMessagePostDetails.visibility = View.VISIBLE
                }
            }
        }
    }

    private fun collectUser() = lifecycleScope.launch {
        viewModel.user.collect {
            when (it) {
                is Resource.Loading -> {
                    binding.loadingBarPostDetails.visibility = View.VISIBLE
                    binding.tvErrorMessagePostDetails.visibility = View.GONE
                }
                is Resource.Success -> {
                    it.data.let { user ->
                        makePostVisible()
                        setupUserViews(user)
                    }
                    binding.loadingBarPostDetails.visibility = View.GONE
                    binding.tvErrorMessagePostDetails.visibility = View.GONE
                }
                is Resource.Error -> {
                    binding.loadingBarPostDetails.visibility = View.GONE
                    binding.tvErrorMessagePostDetails.visibility = View.VISIBLE
                }
            }
        }
    }

    private fun makePostVisible() {
        binding.includePostItem.root.visibility = View.VISIBLE
    }

    private fun getAllPostComments() {
        viewModel.getAllPostComments(getPostId())
    }

    private fun collectComments() = lifecycleScope.launch {
        viewModel.allComments.collect {
            when (it) {
                is Resource.Loading -> {
                    binding.loadingBarPostDetails.visibility = View.VISIBLE
                    binding.tvErrorMessagePostDetails.visibility = View.GONE
                    binding.rvPostComments.visibility = View.GONE
                }
                is Resource.Success -> {
                    postCommentAdapter.submitList(it.data.comments)
                    binding.loadingBarPostDetails.visibility = View.GONE
                    binding.tvErrorMessagePostDetails.visibility = View.GONE
                    binding.rvPostComments.visibility = View.VISIBLE
                }
                is Resource.Error -> {
                    binding.loadingBarPostDetails.visibility = View.GONE
                    binding.tvErrorMessagePostDetails.visibility = View.VISIBLE
                    binding.rvPostComments.visibility = View.GONE
                }
            }
        }
    }

    private fun setupUI(post: Post) = binding.includePostItem.apply {
        tvPostTitle.text = post.title
        tvPostBody.text = post.body
    }

    private fun setupUserViews(user: User) = binding.includePostItem.apply {
        tvPostUserName.text = user.username
        ivUserImage.loadImage(user.image)
    }

    private fun showUserDetailsOnClickUser(id: Int) = binding.includePostItem.apply {
        linearLayoutUser.setOnClickListener {
            navigateToUserDetails(id)
        }
    }

    private fun manageUI() = binding.apply {
        includePostItem.apply {
            disableMaxLinesAndEllipsize(tvPostTitle)
            disableMaxLinesAndEllipsize(tvPostBody)
        }
    }

    private fun disableMaxLinesAndEllipsize(textView: TextView) = textView.apply {
        this.maxLines = Int.MAX_VALUE
        this.ellipsize = null
    }

    private fun getPostById() {
        viewModel.getPostById(getPostId())
    }

    private fun FragmentPostDetailsBinding.bindAdapter(postCommentAdapter: PostCommentAdapter) =
        binding.apply {
            rvPostComments.apply {
                adapter = postCommentAdapter
            }
        }

    private fun navigateToUserDetails(id: Int) {
        val action =
            PostDetailsFragmentDirections.actionPostDetailsFragmentToUserDetailsFragment(id)
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}