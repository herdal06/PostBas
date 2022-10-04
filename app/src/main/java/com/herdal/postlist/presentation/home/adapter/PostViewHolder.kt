package com.herdal.postlist.presentation.home.adapter

import androidx.recyclerview.widget.RecyclerView
import com.herdal.postlist.data.remote.model.post.Post
import com.herdal.postlist.databinding.ItemPostBinding

class PostViewHolder(private val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(post: Post) {
        binding.apply {
            tvPostTitle.text = post.title
        }
    }
}