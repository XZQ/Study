package com.xzq.composestudy.widgets

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.coil.rememberCoilPainter
import com.xzq.composestudy.root.friend.FriendItem
import com.xzq.composestudy.ui.theme.black_10

@Composable
fun ActionTitle(
    it: FriendItem,
    context: Context,
    showLine: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
            .padding(15.dp, 0.dp, 15.dp, 0.dp)
            .height(50.dp)
            .clickable {
                onClick()
            }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // 图片
            Box(modifier = Modifier.size(25.dp)) {
                Image(
                    painter = painterResource(id = it.icon),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(6.dp))
                )
            }
            //
            Row {
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(15.dp, 0.dp, 0.dp, 0.dp)
                        .fillMaxHeight()
                        .weight(3f),
                    content = {
                        Text(
                            text = it.title,
                            fontSize = 17.sp,
                            color = Color.Black
                        )
                    }
                )
                //
                Box(
                    contentAlignment = Alignment.CenterEnd,
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(4f)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        if (it.image != null && it.image != "") {
                            Image(
                                painter = rememberCoilPainter(request = it.image),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(35.dp)
                                    .clip(RoundedCornerShape(6.dp))
                            )
                            Spacer(modifier = Modifier.size(15.dp))
                        }
                        Icon(
                            Icons.Default.ArrowForward, null,
                            modifier = Modifier.size(20.dp),
                            tint = black_10
                        )
                    }
                }
            }
        }
    }
    if (showLine) {
        Divider(
            color = black_10,
            thickness = 0.2.dp,
            modifier = Modifier.padding(start = 70.dp)
        )
    }
}