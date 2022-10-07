package com.herdal.postlist.presentation.post_details.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.herdal.postlist.data.remote.model.comment.Comment
import com.herdal.postlist.databinding.ItemCommentBinding

class PostCommentAdapter : ListAdapter<Comment, PostCommentViewHolder>(DiffCallback) {

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Comment>() {
            override fun areItemsTheSame(oldItem: Comment, newItem: Comment) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Comment, newItem: Comment) =
                oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostCommentViewHolder =
        PostCommentViewHolder(
            ItemCommentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: PostCommentViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }
}