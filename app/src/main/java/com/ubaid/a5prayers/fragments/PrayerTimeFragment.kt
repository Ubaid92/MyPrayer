package com.ubaid.a5prayers.fragments

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.ubaid.a5prayers.R
import com.ubaid.a5prayers.adapter.PrayerTimeAdapter
import com.ubaid.a5prayers.databinding.PrayerTimeFragmentBinding

class PrayerTimeFragment : BaseFragment(R.layout.prayer_time_fragment) {
    lateinit var binding: PrayerTimeFragmentBinding
    lateinit var prayerTimeAdapter: PrayerTimeAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = PrayerTimeFragmentBinding.bind(view)

        prayerTimeAdapter = PrayerTimeAdapter()
        binding.viewPager.adapter = prayerTimeAdapter


        val sliderIndicator = arrayOf(
            binding.slide1,
            binding.slide2,
            binding.slide3,
            binding.slide4,
            binding.slide5,
        )

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)

            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                when (position) {
                    0 -> {
                        binding.root.setBackgroundResource(R.drawable.fajar)

                    }
                    1 -> {
                        binding.root.setBackgroundResource(R.drawable.dhuhr)

                    }
                    2 -> {
                        binding.root.setBackgroundResource(R.drawable.asr)

                    }
                    3 -> {
                        binding.root.setBackgroundResource(R.drawable.maghrib)

                    }
                    4 -> {
                        binding.root.setBackgroundResource(R.drawable.isha)
                    }
                }

                for (i in 0..4) {
                    if (i <= position) {
                        sliderIndicator[i].backgroundTintList =
                            ColorStateList.valueOf(requireActivity().getColor(R.color.gray))
                    } else {
                        sliderIndicator[i].backgroundTintList =
                            ColorStateList.valueOf(requireActivity().getColor(R.color.white))
                    }
                }

            }

        })
        binding.nextbtn.setOnClickListener {
            binding.viewPager.currentItem = binding.viewPager.currentItem + 1

        }
        binding.closeBtn.setOnClickListener {
            popFragment()
        }
    }
}