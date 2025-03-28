package com.xzq.weather

data class HourlyInfo(
    var time: String = "",
    var code: String? = "",
    var code_type: String? = "",
    var temperature: String? = "",
    var text: String? = "",
    var wind_direction: String? = "",
    var wind_speed: String? = ""
)
