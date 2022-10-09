package com.herdal.postlist.presentation.post_details.adapter

import androidx.recyclerview.widget.RecyclerView
import com.herdal.postlist.data.remote.model.comment.Comment
import com.herdal.postlist.databinding.ItemCommentBinding

class PostCommentViewHolder(
    private val binding: ItemCommentBinding,
    private val onClickUser: ((id: Int) -> Unit)?
) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(comment: Comment) = binding.apply {
        tvCommentUserName.text = comment.user.username
        tvComment.text = comment.body
        tvCommentUserName.setOnClickListener {
            onClickUser?.invoke(comment.user.id)
        }
        itemView.setOnClickListener {
            onClickUser?.invoke(comment.user.id)
        }
    }
}