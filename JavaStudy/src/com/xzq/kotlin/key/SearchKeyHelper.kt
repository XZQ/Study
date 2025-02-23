package com.xzq.kotlin.key

class SearchKeyHelper {

    companion object {

        @JvmStatic
        var recentSearchKeys = ""

        @JvmStatic
        var recentSearchKeyList = mutableListOf<String>()

        val instance by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            SearchKeyHelper()
        }

        /**
         * 一个session 只保存一次
         */
        fun clear() {
            recentSearchKeyList.clear()
            recentSearchKeys = ""
        }
    }

    /**
     * 存储最近的3个搜索词
     */
    fun recordRecentThreeSearchKeys(key: String): String {
        if (key.isEmpty()) {
            return recentSearchKeys
        }
        // 新的搜索词，如果存在历史记录，则删除
        if (recentSearchKeyList.isNotEmpty()) {
            recentSearchKeyList = recentSearchKeyList.filter { it != key }.toMutableList()
        }
        // 新搜索词添加到第一位
        recentSearchKeyList.add(0, key)

        // 最大保存3个搜索词
        for (index in recentSearchKeyList.count() - 1 downTo 0) {
            if (index >= 3) {
                recentSearchKeyList.removeAt(index)
            }
        }
        return convertListToString()
    }

    //  将搜索词拼接成字符串
    private fun convertListToString(): String {
        recentSearchKeys = ""

        recentSearchKeyList.forEach {
            recentSearchKeys += it + "_"
        }
        // 先去除下划线
        recentSearchKeys = recentSearchKeys.substring(0, recentSearchKeys.length - 1)

        // 限定搜索词最大长度
        return if (recentSearchKeys.length >= 50) {
            recentSearchKeys.substring(0, 49)
        } else {
            recentSearchKeys
        }
    }
}