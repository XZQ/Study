package com.xzq.composestudy.view

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColor
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.TwoWayConverter
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateValue
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.expandIn
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.shrinkOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.xzq.composestudy.R

// https://blog.csdn.net/EthanCo/article/details/129381503
@Composable
fun AnimateTest() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Animate1()
        Animate2()
        Animate3()
        Spacer(modifier = Modifier.height(10.dp))
        Animate4()
        Spacer(modifier = Modifier.height(10.dp))
//        Animate5()
//        Animate6()
//        Animate7()
//        Animate8()
        AnimatedVisibilityPage()
        AnimateDpAsState()
    }
}

@Composable
fun AnimateDpAsState() {
    var big by remember { mutableStateOf(false) }
    val size by animateDpAsState(
        targetValue = if (big) 300.dp else 50.dp,
        animationSpec = tween(2000, easing = LinearEasing), label = ""
    )

    Box(
        Modifier
            .size(size)
            .background(Color.Blue)
            .clickable {
                big = !big
            }
    )

}

@Composable
fun AnimatedVisibilityPage() {
    var visible by remember { mutableStateOf(true) }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        AnimatedVisibility(
            visible = visible,
            enter = expandIn(),
            exit = shrinkOut()
        ) {
            Image(
                painter = painterResource(id = R.mipmap.ic_1),
                modifier = Modifier.width(300.dp),
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = { visible = !visible }) {
            Text(text = "显示/隐藏")
        }

    }
}


//https://blog.csdn.net/EthanCo/article/details/128601647
@Composable
fun AnimateColorAsState() {
    var big by remember { mutableStateOf(false) }
    val size by animateDpAsState(if (big) 100.dp else 50.dp, label = "")
    val color by animateColorAsState(targetValue = if (big) Color.Red else Color.Blue, label = "")

    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Box(
            Modifier
                .size(size)
                .background(color)
                .clickable {
                    big = !big
                }) {

        }
    }

}


// https://www.jianshu.com/p/bbd4e29ed115
@Composable
fun Animate8() {
    val infiniteTransition = rememberInfiniteTransition(label = "")

    val size by infiniteTransition.animateValue(
        initialValue = 100.dp,
        targetValue = 200.dp,
        typeConverter = TwoWayConverter({ AnimationVector1D(it.value) }, { it.value.dp }),
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )
    val alpha by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )

    Box(
        Modifier
            .size(size)
            .padding(20.dp)
            .alpha(alpha)
            .background(Color.Red)
    )
}


@Composable
fun Animate7() {
    var change by remember { mutableStateOf(false) }
    val transition = updateTransition(targetState = change, label = "多值动画")
    val offset by transition.animateDp(label = "") { if (it) 50.dp else 0.dp }
    val background by transition.animateColor(label = "") { if (it) Color.Gray else Color.Blue }

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = "点击进行多个动画", modifier = Modifier.clickable { change = !change })
        Text(
            text = "这是一个大方块",
            modifier = Modifier
                .size(100.dp)
                .offset(x = offset)
                .background(background),
        )
    }
}


@Composable
fun Animate6() {
    var small by remember { mutableStateOf(true) }
    val size: Dp by animateDpAsState(targetValue = if (small) 40.dp else 100.dp, label = "")
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { small = !small }) {
            Text(text = "改变方块大小")
        }
        Box(
            modifier = Modifier
                .size(size)
                .background(Color.LightGray)
        )
    }
}

@Composable
fun Animate5() {
    var change by remember { mutableStateOf(false) }
    Column {
        Text(text = "点击改变可见性", modifier = Modifier.clickable { change = !change })
        AnimatedVisibility(
            visible = change,
            enter = slideInVertically(
                initialOffsetY = { fullHeight -> -fullHeight },
                animationSpec = tween(durationMillis = 150, easing = LinearOutSlowInEasing)
            ),
            exit = slideOutVertically(
                targetOffsetY = { fullHeight -> -fullHeight },
                animationSpec = tween(durationMillis = 250, easing = FastOutSlowInEasing)
            )
        ) {
            Text(
                text = "这是一个大方块",
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Gray),
            )
        }
    }
}

@Composable
fun Animate4() {
    var change by remember { mutableStateOf(false) }
    Column {
        Text(text = "点击改变可见性", modifier = Modifier.clickable { change = !change })

        AnimatedVisibility(visible = change) {
            Text(
                text = "这是一个大方块",
                modifier = Modifier
                    .size(120.dp)
                    .background(Color.Gray),
            )
        }
    }
}

@Composable
fun Animate3() {
    var change by remember { mutableStateOf(false) }

    Column(modifier = Modifier.animateContentSize()) {

        Text(text = "点击改变内容大小", modifier = Modifier.clickable { change = !change })

        if (change) {
            Text(
                text = "这是一个大方块",
                modifier = Modifier
                    .size(120.dp)
                    .background(Color.Gray),
            )
        }
    }
}

@Composable
fun Animate2() {
    var visible by remember { mutableStateOf(false) }
    AnimatedVisibility(
        visible = visible,
        enter = scaleIn(),
        exit = scaleOut()
    ) {
        Image(painter = painterResource(id = R.mipmap.icon_applet), contentDescription = null)
    }
    Button(
        onClick = { visible = !visible },
        modifier = Modifier.padding(vertical = 10.dp)
    ) {
        val value = if (visible) "显示" else "隐藏"
        Text(text = value)
    }
}

@Composable
fun Animate1() {
    var visible by remember { mutableStateOf(false) }
    AnimatedVisibility(visible = visible) {
        Image(painter = painterResource(id = R.mipmap.icon_applet), contentDescription = null)
    }
    Button(
        onClick = { visible = !visible },
        modifier = Modifier.padding(vertical = 10.dp)
    ) {
        val value = if (visible) "显示" else "隐藏"
        Text(text = value)
    }
}
