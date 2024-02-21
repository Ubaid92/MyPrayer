package com.ubaid.a5prayers.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ubaid.a5prayers.data.PrayersTimeData
import com.ubaid.a5prayers.databinding.PrayersTimeSlidesBinding

class PrayerTimeAdapter : RecyclerView.Adapter<PrayerTimeAdapter.ViewHolder>() {
    val prayerTimeList = arrayListOf<PrayersTimeData>()

    inner class ViewHolder(val binding: PrayersTimeSlidesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun hold(prayersTimeData: PrayersTimeData) {
            binding.prayerName.text = prayersTimeData.prayerName
            binding.prayerTime.text = prayersTimeData.prayerTime.toString()
            binding.countDownTime.text = prayersTimeData.countDown.toString()
            binding.alarmOnOff.isActivated = prayersTimeData.isAlarm
            binding.cityNameText.text = prayersTimeData.cityName
            binding.hijriDate.text = prayersTimeData.todayHijriDate
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding =
            PrayersTimeSlidesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.hold(PrayersTimeData("","",0L,0L,"",false))
    }
}