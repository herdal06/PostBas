package com.herdal.postlist.presentation.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.herdal.postlist.databinding.FragmentHomeBinding
import com.herdal.postlist.presentation.home.adapter.PostAdapter
import com.herdal.postlist.util.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModels()
    private val postAdapter: PostAdapter by lazy {
        PostAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        collectData()
        binding.bindAdapter(postAdapter = postAdapter)
    }

    private fun collectData() = lifecycleScope.launch {
        viewModel.allPosts.collect {
            when (it) {
                is Resource.Loading -> {
                    binding.loadingBar.visibility = View.VISIBLE
                    binding.tvErrorMessage.visibility = View.GONE
                    binding.rvPosts.visibility = View.GONE
                }
                is Resource.Success -> {
                    postAdapter.submitList(it.data.posts)
                    binding.loadingBar.visibility = View.GONE
                    binding.tvErrorMessage.visibility = View.GONE
                    binding.rvPosts.visibility = View.VISIBLE
                    Log.d("HomeFragment", "$it.data.posts")
                }
                is Resource.Error -> {
                    binding.loadingBar.visibility = View.GONE
                    binding.tvErrorMessage.visibility = View.VISIBLE
                    binding.rvPosts.visibility = View.GONE
                }
                else -> {}
            }
        }
    }

    private fun FragmentHomeBinding.bindAdapter(postAdapter: PostAdapter) = binding.apply {
        rvPosts.apply {
            adapter = postAdapter
            layoutManager = LinearLayoutManager(rvPosts.context)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}