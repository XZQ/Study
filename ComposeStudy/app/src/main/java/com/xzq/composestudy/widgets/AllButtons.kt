package com.xzq.composestudy.widgets

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconToggleButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.xzq.composestudy.ui.theme.Typography
import com.xzq.composestudy.ui.theme.purple

// https://blog.csdn.net/qq_31339141/article/details/124227120
// https://zhuanlan.zhihu.com/p/619110976
// https://blog.csdn.net/Bluechalk/article/details/128064145
// https://www.cnblogs.com/guanxinjing/p/17603239.html
@Composable
fun PreviewButtons() {
    Column {
        AllButtons()
    }
}

@Composable
fun AllButtons() {
    val context1 = LocalContext.current

    Text(text = "Button", style = Typography.h5, modifier = Modifier.padding(2.dp))

    Row(verticalAlignment = Alignment.CenterVertically) {
        Button(onClick = { }, modifier = Modifier.padding(2.dp)) {
            Text(text = "Main Button")
        }
        Button(onClick = {}, modifier = Modifier.padding(2.dp), enabled = false) {
            Text(text = "Disabled")
        }
        Button(
            onClick = {}, modifier = Modifier.padding(2.dp),
            elevation = ButtonDefaults.buttonElevation()
        ) {
            Text(text = "Flat")
        }
    }
    /****************************************/
    Row(verticalAlignment = Alignment.CenterVertically) {
        Button(
            onClick = {},
            modifier = Modifier.padding(2.dp),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(text = "Rounded")
        }
        Button(onClick = {}, modifier = Modifier.padding(2.dp)) {
            Row {
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = null,
                    modifier = Modifier.padding(end = 2.dp)
                )
                Text(text = "Icon Button")
            }
        }
        Button(onClick = {}, modifier = Modifier.padding(2.dp)) {
            Text(text = "Icon Button")
            Icon(
                imageVector = Icons.Default.FavoriteBorder,
                contentDescription = null,
                modifier = Modifier.padding(start = 4.dp)
            )
        }
    }
    /****************************************/
    Row(verticalAlignment = Alignment.CenterVertically) {
        TextButton(onClick = { }, modifier = Modifier.padding(2.dp)) {
            Text(text = "TextButton")
        }
        TextButton(onClick = { }, modifier = Modifier.padding(2.dp), enabled = false) {
            Text(text = "Text Disabled")
        }
        TextButton(onClick = { }) {
            Text(text = "点击")
        }
    }
    /****************************************/
    val outlineButtonColor = ButtonDefaults.outlinedButtonColors(
        contentColor = Color.Cyan,
    )
    Row(verticalAlignment = Alignment.CenterVertically) {
        OutlinedButton(
            colors = outlineButtonColor,
            onClick = {},
            modifier = Modifier.padding(2.dp)
        ) {
            Text(text = "Outline colors")
        }
        OutlinedButton(onClick = {}, modifier = Modifier.padding(8.dp)) {
            Text(text = "Outline")
        }
        OutlinedButton(onClick = { }) {
            Text(text = "点击", color = Color.Red)
        }
    }
    /****************************************/
    val isChecked = remember { mutableStateOf(true) }
    val mainButtonColor = ButtonDefaults.buttonColors(
        containerColor = purple,
        contentColor = MaterialTheme.colorScheme.surface
    )
    Row(verticalAlignment = Alignment.CenterVertically) {
        IconToggleButton(checked = isChecked.value, onCheckedChange = {
            isChecked.value = it
        }) {
            Icon(
                imageVector = if (isChecked.value) Icons.Default.CheckCircle else Icons.Default.Check,
                contentDescription = null,
                tint = Color.Cyan
            )
        }
        Button(colors = mainButtonColor, onClick = {}, modifier = Modifier.padding(2.dp)) {
            Text(text = "Custom colors")
        }
    }
    /****************************************/
    Row {
        val horizontalGradient = Brush.horizontalGradient(
            colors = listOf(MaterialTheme.colorScheme.primary, MaterialTheme.colorScheme.inversePrimary),
            0f,
            250f
        )
        val verticalGradient = Brush.verticalGradient(
            colors = listOf(MaterialTheme.colorScheme.primary, MaterialTheme.colorScheme.inversePrimary),
            startY = 0f,
            endY = 100f
        )
        Text(
            text = "Horizontal gradient",
            style = Typography.body2.copy(color = Color.White),
            modifier = Modifier
                .padding(12.dp)
                .clickable(onClick = {})
                .clip(RoundedCornerShape(4.dp))
                .background(brush = horizontalGradient)
                .padding(12.dp)
        )
        Text(
            text = "Vertical gradient",
            style = Typography.body1.copy(color = Color.White),
            modifier = Modifier
                .padding(12.dp)
                .clickable(onClick = {})
                .clip(RoundedCornerShape(4.dp))
                .background(brush = verticalGradient)
                .padding(12.dp)
        )
    }
    /****************************************/
    val isEnabled = remember { mutableStateOf(true) }
    val buttonColors = ButtonDefaults.buttonColors(
        containerColor = Color.Red,
        contentColor = Color.Yellow,
        disabledContainerColor = Color.DarkGray,
        disabledContentColor = Color.Black
    )

    //点击状态来源
    val interactionSource = remember { MutableInteractionSource() }
    //interactionSource.collectIsPressedAsState() 为按下状态
    //interactionSource.collectIsFocusedAsState() 为焦点选中状态
    //interactionSource.collectIsHoveredAsState() 为鼠标悬停状态
    //interactionSource.collectIsDraggedAsState() 为拖动状态
    val buttonColors1 = if (interactionSource.collectIsPressedAsState().value) {
        ButtonDefaults.buttonColors(
            containerColor = Color.Gray,
            contentColor = Color.White,
        )
    } else {
        ButtonDefaults.buttonColors(
            containerColor = Color.Cyan,
            contentColor = Color.Black,
        )
    }
    Row(verticalAlignment = Alignment.CenterVertically) {
        Button(
            onClick = {
                Toast.makeText(context1, "点击按钮", Toast.LENGTH_SHORT).show()
            },
            enabled = isEnabled.value,
            colors = buttonColors,
            border = BorderStroke(2.dp, Brush.linearGradient(listOf(Color(0xFF005599), Color(0xFF3FFFED)))),
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 10.dp)//阴影
        ) {
            Text(text = "点击")
        }
        Button(
            onClick = { isEnabled.value = !isEnabled.value },
            border = BorderStroke(1.dp, Color.Green),
            colors = buttonColors1,
            interactionSource = interactionSource
        ) {
            Text(text = "是否可用")
        }
    }
}


/*    val swipeButtonState = remember {
        mutableStateOf(SwipeButtonState.INITIAL)
    }
    val coroutineScope = rememberCoroutineScope()
    SwipeButton(
        onSwiped = {
            swipeButtonState.value = SwipeButtonState.SWIPED
            coroutineScope.launch {
                delay(2000)
                swipeButtonState.value = SwipeButtonState.COLLAPSED
            }
        },
        swipeButtonState = swipeButtonState.value,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(60.dp),
        iconPadding = PaddingValues(4.dp),
        shape = CircleShape,
    ) {
        Text(text = "PAY NOW", style = Typography.h6.copy(fontSize = 16.sp))
    }
    SwipeButton(
        onSwiped = {},
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        iconPadding = PaddingValues(4.dp),
        swipeButtonState = SwipeButtonState.INITIAL,
        shape = CircleShape,
        enabled = false
    ) {
        Text(text = "Swipe", style = Typography.body1)
    }*/


