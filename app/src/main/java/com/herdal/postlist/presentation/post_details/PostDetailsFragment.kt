package com.herdal.postlist.presentation.post_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.herdal.postlist.databinding.FragmentPostDetailsBinding
import com.herdal.postlist.presentation.post_details.adapter.PostCommentAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostDetailsFragment : Fragment() {

    private var _binding: FragmentPostDetailsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val viewModel: PostDetailsViewModel by viewModels()
    private val navigationArgs: PostDetailsFragmentArgs by navArgs()
    private val postCommentAdapter: PostCommentAdapter by lazy {
        PostCommentAdapter()
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.bindAdapter(postCommentAdapter = postCommentAdapter)
        manageUI()
    }

    private fun manageUI() = binding.apply {
        includePostItem.apply {
            tvPostBody.apply {
                // disable maxLines and ellipsize
                this.maxLines = Int.MAX_VALUE
                this.ellipsize = null
            }
        }
    }

    private fun FragmentPostDetailsBinding.bindAdapter(postCommentAdapter: PostCommentAdapter) =
        binding.apply {
            rvPostComments.apply {
                adapter = postCommentAdapter
            }
        }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}