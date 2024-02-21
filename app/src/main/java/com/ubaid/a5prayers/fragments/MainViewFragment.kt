package com.ubaid.a5prayers.fragments

import android.os.Bundle
import android.view.View
import com.ubaid.a5prayers.R
import com.ubaid.a5prayers.databinding.MainViewFragmentBinding

class MainViewFragment:BaseFragment(R.layout.main_view_fragment) {
    lateinit var binding: MainViewFragmentBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = MainViewFragmentBinding.bind(view)

        binding.prayerTimeView.setOnClickListener {
            addFragment(PrayerTimeFragment())
        }
    }
}