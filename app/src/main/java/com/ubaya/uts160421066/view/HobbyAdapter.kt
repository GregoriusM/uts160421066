package com.ubaya.uts160421066.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ubaya.uts160421066.R
import com.ubaya.uts160421066.databinding.HobbyCardBinding
import com.ubaya.uts160421066.model.response.HobbiesItem

class HobbyAdapter : ListAdapter<HobbiesItem, HobbyAdapter.MyViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK: DiffUtil.ItemCallback<HobbiesItem> =
            object : DiffUtil.ItemCallback<HobbiesItem>() {
                override fun areItemsTheSame(oldItem: HobbiesItem, newItem: HobbiesItem): Boolean {
                    return oldItem.title == newItem.title
                }

                override fun areContentsTheSame(
                    oldItem: HobbiesItem,
                    newItem: HobbiesItem
                ): Boolean {
                    return oldItem == newItem
                }
            }
    }

    inner class MyViewHolder(private val binding: HobbyCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(hobby: HobbiesItem) {
            val urlBase: String = "http://192.168.151.105/uts160421066/images/"
            binding.apply {
                titleTextView.text = hobby.title
                usernameTextView.text = hobby.username
                descriptionTextView.text = hobby.description
                Glide.with(itemView)
                    .load(urlBase + hobby.image)
                    .centerCrop()
                    .into(imageView)

                // Mengatur action ketika tombol "Read" diklik
                readButton.setOnClickListener {
                    val detailDescription = hobby.detailDescription
                    descriptionTextView.text = detailDescription
                    readButton.visibility = View.GONE
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =
            HobbyCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
