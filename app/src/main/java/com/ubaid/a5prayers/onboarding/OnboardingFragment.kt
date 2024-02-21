package com.ubaid.a5prayers.onboarding

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.ubaid.a5prayers.R
import com.ubaid.a5prayers.adapter.OnBoardingAdapter
import com.ubaid.a5prayers.data.OnBoardingData
import com.ubaid.a5prayers.databinding.OnBoardingFragmentBinding
import com.ubaid.a5prayers.fragments.BaseFragment
import com.ubaid.a5prayers.fragments.MainViewFragment

class OnboardingFragment : BaseFragment(R.layout.on_boarding_fragment) {
    lateinit var binding: OnBoardingFragmentBinding
    private lateinit var onBoardingAdapter: OnBoardingAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = OnBoardingFragmentBinding.bind(view)


        val onBoardingList = arrayListOf<OnBoardingData>(
            OnBoardingData("Prayer time", "You never miss your prayer time", R.raw.muslim),
            OnBoardingData("News", "Get verses, quotes, hadith", R.raw.muslim)
        )

        onBoardingAdapter = OnBoardingAdapter()
        onBoardingAdapter.onBoardList = onBoardingList
        binding.viewPager.adapter = onBoardingAdapter

        val sliderIndicator = arrayOf(
            binding.slide1,
            binding.slide2,
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

                if (position == 1) {
                    binding.skipbtn.visibility = View.GONE
                    binding.nextbtn.text = "Get Started -->"
                } else {
                    binding.skipbtn.visibility = View.VISIBLE
                    binding.nextbtn.text = "Next-->"
                }

                for (i in 0..1) {
                    if (i <= position) {
                        sliderIndicator[i].backgroundTintList =
                            ColorStateList.valueOf(requireActivity().getColor(R.color.black))
                    } else {
                        sliderIndicator[i].backgroundTintList =
                            ColorStateList.valueOf(requireActivity().getColor(R.color.gray))
                    }
                }

            }
        })

        binding.nextbtn.setOnClickListener {
            if (binding.viewPager.currentItem == 1) {

                replaceFragment(MainViewFragment())

            } else {
                binding.viewPager.currentItem = binding.viewPager.currentItem + 1
            }
        }

        binding.skipbtn.setOnClickListener {
            binding.viewPager.currentItem = 1
        }

    }
}