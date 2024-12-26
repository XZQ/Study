package com.xzq.xzq


class AvailableTime {
    var date: Long = 0

    var dayOfWeek: Int = 0

    var isFull: Boolean = false

    var times: List<TimeItem>? = null

    var monthName: String? = ""

    var hourName: String? = ""

    var hour: Long = 0

    var available: Boolean = false

    override fun toString(): String {
        return "AvailableTime(date=$date, times=${times?.size}, hour=${TimeUtils.format.format(hour * 1000)} )"
    }
}

class TimeItem {
    // 每半小时整点的10位时间戳
    var time: Long = 0

    // 是否可预约
    var available: Boolean = false

    // 非必须 1001：移动服务；1005:上门取车，1010:移动服务和上门取车
    var resourceType: Int = 0

    //  为time 转换为后 应该显示的 文本
    var showText: String = ""

    override fun toString(): String {
        return "TimeItem(time=${TimeUtils.format.format(time)}     time=$time, available=$available,   showText='$showText')"
    }


}

class DriverAvailableTime {
    var time: Long = 0

    var date: Long = 0L

    var availableTimeList: List<AvailableTime>? = null

    //  为time 转换为后 应该显示的 文本
    var showText: String = ""

    var dayOfWeek: Int = 0

    var available: Boolean = false

    override fun toString(): String {
        return "TimeItem(time=${TimeUtils.format.format(date)},  date=$date , availableTimeList=${availableTimeList?.size})"
    }

}



