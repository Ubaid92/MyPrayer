package com.ubaid.a5prayers.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ubaid.a5prayers.data.OnBoardingData
import com.ubaid.a5prayers.databinding.OnBoardingSlideBinding

class OnBoardingAdapter : RecyclerView.Adapter<OnBoardingAdapter.ViewHolder>() {

     var onBoardList = arrayListOf<OnBoardingData>()

    inner class ViewHolder(private val binding: OnBoardingSlideBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun hold(onBoardingData: OnBoardingData) {
            binding.heading.text = onBoardingData.title
            binding.text1.text = onBoardingData.description
            binding.image.setAnimation(onBoardingData.image)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            OnBoardingSlideBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return onBoardList.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.hold(onBoardList[position])
    }
}