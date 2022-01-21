package com.example.flags

import android.provider.MediaStore
import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.flags.databinding.GridViewItemBinding

class FlagGridAdapter :androidx.recyclerview.widget.ListAdapter<FlagsData, FlagGridAdapter.FlagViewHolder>(DiffCallback) {

    class FlagViewHolder(

        private val binding: GridViewItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        //=================================================================================
        fun bind(PhotoItem: FlagsData) {
            binding.apply {

               photo = PhotoItem
              executePendingBindings()
            }
        }

    }
    //=================================================================================

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlagViewHolder {
        return FlagViewHolder(GridViewItemBinding.inflate(LayoutInflater.from(parent.context)))
    }
    //=================================================================================
    companion object DiffCallback : DiffUtil.ItemCallback<FlagsData>() {
        override fun areItemsTheSame(oldItem: FlagsData, newItem: FlagsData): Boolean {
            return oldItem.name == newItem.name
        }


        override fun areContentsTheSame(oldItem: FlagsData, newItem: FlagsData): Boolean {
            return oldItem.flag == newItem.flag
        }
    }
    //=================================================================================


    override fun onBindViewHolder(holder: FlagViewHolder, position: Int) {
        val images = getItem(position)
        holder.bind(images)
        //=================================================================================
    }
}
