package com.github.isacwq.businesscard.ui.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.github.isacwq.businesscard.data.BusinessCard
import com.github.isacwq.businesscard.databinding.CardItemBinding


class BusinessCardAdapter :
    ListAdapter<BusinessCard, BusinessCardAdapter.ViewHolder>(BusinessCardDiffCallback()) {

    inner class ViewHolder(private val binding: CardItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindItem(businessCard: BusinessCard) {
            binding.tvName.text = businessCard.name
            binding.tvPhone.text = businessCard.phone
            binding.tvEmail.text = businessCard.email
            binding.tvCompany.text = businessCard.company

            itemView.setBackgroundColor(Color.parseColor(businessCard.color))
            itemView.setOnClickListener {
                listenerShare(it)
            }
        }
    }

    var listenerShare: (View) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(getItem(position))
    }
}

private class BusinessCardDiffCallback : DiffUtil.ItemCallback<BusinessCard>() {
    override fun areItemsTheSame(oldItem: BusinessCard, newItem: BusinessCard) = oldItem == newItem

    override fun areContentsTheSame(oldItem: BusinessCard, newItem: BusinessCard) =
        oldItem.id == newItem.id
}