package com.xzq.flow

import kotlinx.coroutines.channels.Channel


/**
 *
 * capacity的其它固定类型
 *
 * RENDEZVOUS，默认类型；send数据后，如果，一直没有receive的话，就会挂起。
 * CONFLATED，新元素会替代旧元素，receive一直会获取最新的数据
 * UNLIMITED，缓冲区没有限制；一直可以send数据
 * BUFFERED，指定元素大小，默认为64，当满了后Send会被挂起(可通过程序参数修改)。
 *
 *
 */
val channelSource = Channel<Int>()