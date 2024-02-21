package com.ubaid.a5prayers.data

data class PrayersTimeData(
    val cityName: String,
    val prayerName: String,
    val prayerTime: Long,
    val countDown: Long,
    val todayHijriDate: String,
    val isAlarm: Boolean
)
