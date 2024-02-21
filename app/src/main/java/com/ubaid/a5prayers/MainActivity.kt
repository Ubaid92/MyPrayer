package com.ubaid.a5prayers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ubaid.a5prayers.databinding.ActivityMainBinding
import com.ubaid.a5prayers.fragments.BaseFragment
import com.ubaid.a5prayers.onboarding.OnboardingFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction().add(R.id.container, OnboardingFragment()).commit()
    }

    fun replace(fragment: BaseFragment) {
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
    }

    fun replaceAndAdd(fragment: BaseFragment) {
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment)
            .addToBackStack(fragment::class.simpleName).commit()
    }

    fun add(fragment: BaseFragment) {
        supportFragmentManager.beginTransaction().add(R.id.container, fragment)
            .addToBackStack(fragment::class.simpleName).commit()
    }

}