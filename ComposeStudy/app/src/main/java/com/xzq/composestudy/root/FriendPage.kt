package com.xzq.composestudy

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.xzq.composestudy.root.friend.FriendItem
import com.xzq.composestudy.widgets.ActionTitle
import kotlin.math.roundToInt

@Composable
fun rootFriendPage(innerPadding: PaddingValues) {

    val context = LocalContext.current
    val srollState = rememberLazyListState()
    val statusBarHeight = LocalDensity.current.run { WindowInsets.statusBars.getTop(this).toDp() }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp  )
    ) {
        LazyColumn(
            contentPadding = innerPadding,
            state = srollState,
            modifier = Modifier
                .fillMaxSize()
                .background(Color(ContextCompat.getColor(context, R.color.nav_bg)))
        ) {
            item {
                divider()
            }
            item {
                ActionTitle(
                    FriendItem(
                        "朋友圈",
                        R.mipmap.icon_friends,
                        "https://img.duoziwang.com/2019/07/12080849900677.jpg"
                    ), context, false,
                    onClick = {
                        // MomentActivity.navigate(context)
                    })
                divider(thickness = 10.dp, colorId = R.color.nav_bg)
            }
            item {
                ActionTitle(
                    FriendItem(
                        "直播",
                        R.mipmap.icon_live,
                    ), context, false,
                    onClick = {})
                divider(thickness = 10.dp, colorId = R.color.nav_bg)
            }
            item {
                ActionTitle(
                    FriendItem(
                        "扫一扫",
                        R.mipmap.icon_scan,
                    ), context, true,
                    onClick = {})
            }
            item {
                ActionTitle(
                    FriendItem(
                        "摇一摇",
                        R.mipmap.icon_yao,
                    ), context, true,
                    onClick = {})
                divider(thickness = 10.dp, colorId = R.color.nav_bg)
            }
            item {
                ActionTitle(
                    FriendItem(
                        "看一看",
                        R.mipmap.icon_look,
                    ), context, true,
                    onClick = {})
            }
            item {
                ActionTitle(
                    FriendItem(
                        "搜一搜",
                        R.mipmap.icon_search,
                    ), context, true,
                    onClick = {})
                divider(thickness = 10.dp, colorId = R.color.nav_bg)
            }
            item {
                ActionTitle(
                    FriendItem(
                        "附近",
                        R.mipmap.icon_near,
                    ), context, false,
                    onClick = {})
                divider(thickness = 10.dp, colorId = R.color.nav_bg)
            }
            item {
                ActionTitle(
                    FriendItem(
                        "小程序",
                        R.mipmap.icon_applet,
                    ), context, false,
                    onClick = {})
            }
        }
    }
}

@Composable
fun divider(thickness: Dp? = 0.2.dp, colorId: Int? = R.color.gray_10) {
    val height = thickness ?: 0.2.dp
    val context = LocalContext.current
    val color = colorId ?: R.color.gray_10
    Divider(
        color = Color(ContextCompat.getColor(context, color)),
        thickness = height,
    )
}


// https://blog.csdn.net/shop_and_sleep/article/details/127191087
@Composable
fun NationalDayItem(
    name: String,
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = name,
            modifier = Modifier
                .weight(1F)
                .padding(18.dp)
        )
        IconButton(onClick = onClose) {
            Icon(Icons.Default.Close, contentDescription = "onClose")
        }
    }
}

@Composable
fun NationalDay(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {

        var day by remember { mutableIntStateOf(7) }
        var showNotice by remember { mutableStateOf(false) }
        var count by remember { mutableIntStateOf(0) }

        if (day < 1) {
            if (count == 0) {
                showNotice = true
            }
            count++
            if (showNotice) {
                NationalDayItem("你要上班了", onClose = { showNotice = false })
            }
        }
        Text(
            text = "我们有 $day 天来庆祝国庆节!",
            modifier = modifier.padding(16.dp)
        )
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = { day-- },
                modifier = Modifier.weight(1F)
            ) {
                Text(text = "玩一天")
            }
            Button(
                onClick = { day = 7 },
                Modifier
                    .weight(1F)
                    .padding(start = 10.dp)
            ) {
                Text(text = "重新过国庆节")
            }
            Image(painterResource(R.drawable.ic_launcher_background), "Avatar")
        }
    }
}


// https://blog.csdn.net/lplj717/article/details/121925809
//  modifier的顺序不同会导致效果不同
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun boxTest() {
    val context = LocalContext.current
    Column(modifier = Modifier) {
        Box(
            modifier = Modifier
//                .fillMaxSize(fraction = 0.5f)
                .sizeIn(minWidth = 40.dp, minHeight = 40.dp)
                .size(100.dp)
                .background(Color.Green)

        )

        Box(
            Modifier
                .sizeIn(minWidth = 40.dp, minHeight = 40.dp)
                .wrapContentSize(Alignment.TopEnd)
                .size(20.dp)
                .background(Color.Red)
        )
        /*
               Spacer(modifier = Modifier.requiredHeight(10.dp))

               Row {
                   Box(
                       Modifier
                           .sizeIn(minWidth = 40.dp, minHeight = 40.dp)
                           .size(20.dp)//设置的size小于最小宽高，最终渲染出来的就是40*40的
                           .background(Color.Blue)
                   )
                   Box(
                       Modifier
                           .sizeIn(minWidth = 40.dp, minHeight = 40.dp)
                           .wrapContentSize(Alignment.TopCenter)//设置wrapContentSize
                           .size(20.dp)//设置的size小于最小宽高，最终渲染出来的就是20*20的，对齐方式为TopCenter
                           .background(Color.Red)
                   )
                   Box(
                       Modifier
                           .sizeIn(minWidth = 40.dp, minHeight = 40.dp)
                           .wrapContentHeight(Alignment.CenterVertically)//设置wrapContentSize
                           .height(20.dp)//高20，宽40，垂直居中
                           .background(Color.Yellow)
                   )
                   Box(
                       Modifier
                           .sizeIn(minWidth = 40.dp, minHeight = 40.dp)
                           .wrapContentWidth(Alignment.CenterHorizontally)//设置wrapContentSize
                           .width(20.dp)//宽20，高40，水平居中
                           .background(Color.Green)
                   )
               }
               Box(
                   Modifier
                       .size(50.dp)
                       .background(Color.Blue)
                       .combinedClickable(
                           onLongClick = {
                               Toast
                                   .makeText(context, "长按", Toast.LENGTH_SHORT)
                                   .show()
                           },
                           onDoubleClick = {
                               Toast
                                   .makeText(context, "双击", Toast.LENGTH_SHORT)
                                   .show()
                           },
                           onClick = {
                               Toast
                                   .makeText(context, "点击", Toast.LENGTH_SHORT)
                                   .show()
                           })
               )

              Spacer(modifier = Modifier.requiredHeight(10.dp))
               Row() {
                   val gradientBrush = Brush.horizontalGradient(
                       colors = listOf(Color.Red, Color.Blue, Color.Green),
                       startX = 0.0f,
                       endX = 350.0f,
                       tileMode = TileMode.Repeated
                   )
                   Text(
                       text = "我是测试边框",
                       modifier = Modifier
                           .border(width = 2.dp, brush = gradientBrush, shape = CircleShape)
                           .padding(10.dp)
                   )

                   val colorList = arrayListOf(Color(0xFF25BC6B), Color(0xFFFFCA1C))
                   Box(
                       modifier = Modifier
                           .width(220.dp)
                           .height(44.dp)
                           .background(
                               brush = Brush.horizontalGradient(colorList),
                               shape = RoundedCornerShape(50)
                           )
                           .padding(10.dp)

                   )
               }
        Column(Modifier.verticalScroll(rememberScrollState())) {
            repeat(1000) {
                Box(
                    Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                ) {
                    Text(text = "item：$it")
                }
            }
        }*/
        val offset = remember { mutableStateOf(0f) }
        Box(
            Modifier
                .size(150.dp)
                .scrollable(
                    orientation = Orientation.Vertical,
                    // state for Scrollable, describes how consume scroll amount
                    state = rememberScrollableState { delta ->
                        offset.value = offset.value + delta // update the state
                        delta // indicate that we consumed all the pixels available
                    }
                )
                .background(Color.LightGray),
            contentAlignment = Alignment.Center
        ) {
            Text(offset.value.roundToInt().toString(), style = TextStyle(fontSize = 32.sp))
        }

    }
}
