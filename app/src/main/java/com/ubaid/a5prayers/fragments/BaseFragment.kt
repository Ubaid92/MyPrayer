package com.ubaid.a5prayers.fragments

import androidx.fragment.app.Fragment
import com.ubaid.a5prayers.MainActivity

open class BaseFragment(int: Int) : Fragment(int) {

    fun addFragment(fragment: BaseFragment){
        (requireActivity() as MainActivity).add(fragment)
    }

    fun replaceFragment(fragment: BaseFragment){
        (requireActivity() as MainActivity).replace(fragment)
    }
    fun replaceFragmentAndAddToBackStack(fragment: BaseFragment){
        (requireActivity() as MainActivity).replaceAndAdd(fragment)
    }

    fun popFragment() {
        requireActivity().supportFragmentManager.popBackStack()

    }
}