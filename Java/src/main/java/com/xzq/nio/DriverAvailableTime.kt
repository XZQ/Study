class DriverAvailableTime {
    var time: Long = 0

    var date: String = ""

    //"日", "一", "二", "三", "四", "五", "六"
    var dayOfWeek: String = ""

    var availableTimeList: List<AvailableTime>? = null

    //  为time 转换为后 应该显示的 文本
    var showText: String = ""

    var isSelect: kotlin.Boolean = false
}

class AvailableTime {
    var date: Long = 0

    var day_of_week: Int = 0

    var is_full: Boolean = false

    var times: List<TimeItem>? = null

    var monthName: String? = ""

    var hourName: String? = ""
}

class TimeItem {

    // 每半小时整点的10位时间戳
    var time: Long = 0

    // 是否可预约
    var available: Boolean = false

    // 非必须 1001：移动服务；1005:上门取车，1010:移动服务和上门取车
    var resource_type: Int = 0

    //  为time 转换为后 应该显示的 文本
    var showText: String = ""

}
