package com.herdal.postlist.presentation.home.adapter

import androidx.recyclerview.widget.RecyclerView
import com.herdal.postlist.data.remote.model.post.Post
import com.herdal.postlist.databinding.ItemPostBinding

class PostViewHolder(
    private val binding: ItemPostBinding,
    private val onClickPost: ((postId: Int, userId: Int) -> Unit)?,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(post: Post) {
        binding.apply {
            tvPostTitle.text = post.title
            tvPostBody.text = post.body
            icComment.setOnClickListener {
                onClickPost?.invoke(post.id, post.userId)
            }
            itemView.setOnClickListener {
                onClickPost?.invoke(post.id, post.userId)
            }
            tvPostUserName.setOnClickListener {
                onClickPost?.invoke(post.id, post.userId)
            }
        }
    }
}