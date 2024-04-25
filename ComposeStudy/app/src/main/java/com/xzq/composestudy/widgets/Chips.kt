package com.xzq.composestudy.widgets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.xzq.composestudy.R
import com.xzq.composestudy.utils.SubtitleText


@Composable
fun Chips() {
    SubtitleText(subtitle = "Custom chips with surface")
    Row(modifier = Modifier.padding(8.dp)) {
        YoutubeChip(selected = true, text = "Chip", modifier = Modifier.padding(horizontal = 8.dp))
        YoutubeChip(
            selected = false,
            text = "Inactive",
            modifier = Modifier.padding(horizontal = 8.dp)
        )
        CustomImageChip(text = "custom", imageId = R.mipmap.icon_scan, selected = true)
        Spacer(modifier = Modifier.padding(8.dp))
        CustomImageChip(text = "custom2", imageId = R.mipmap.icon_search, selected = false)
    }
    SubtitleText(subtitle = "Buttons with circle clipping.")
    Row(modifier = Modifier.padding(8.dp)) {
        Button(
            onClick = {},
            modifier = Modifier
                .padding(8.dp)
                .clip(CircleShape)
        ) {
            Text(text = "Chip button")
        }
        Button(
            onClick = {},
            enabled = false,
            modifier = Modifier
                .padding(8.dp)
                .clip(CircleShape)
        ) {
            Text(text = "Disabled chip")
        }
    }
}

@Composable
fun YoutubeChip(selected: Boolean, text: String, modifier: Modifier = Modifier) {
    Surface(
        color = when {
            selected -> MaterialTheme.colors.onSurface.copy(
                alpha = if (MaterialTheme.colors.isLight) 0.7f else 1f
            )
            else -> androidx.compose.material3.MaterialTheme.colorScheme.inverseOnSurface.copy(
                alpha = 0.05f
            )
        },
        contentColor = when {
            selected -> androidx.compose.material3.MaterialTheme.colorScheme.surface
            else -> androidx.compose.material3.MaterialTheme.colorScheme.onSurface
        },
        shape = CircleShape,
        border = BorderStroke(
            width = 1.dp,
            color = when {
                selected -> androidx.compose.material3.MaterialTheme.colorScheme.surface
                else -> Color.LightGray
            }
        ),
        modifier = modifier
    ) {
        Text(
            text = text,
            textAlign = TextAlign.Center,
            style = typography.bodyMedium,
            modifier = Modifier.padding(
                vertical = 8.dp,
                horizontal = 12.dp,
            )
        )
    }
}

//Inspired from jetcaster sample. I hope compose can add simple Chip UI element that can
// support images or icons with multiple states.
@Composable
private fun CustomImageChip(
    text: String,
    imageId: Int,
    selected: Boolean,
    modifier: Modifier = Modifier
) {
    Surface(
        color = when {
            selected -> androidx.compose.material3.MaterialTheme.colorScheme.primary
            else -> Color.Transparent
        },
        contentColor = when {
            selected -> androidx.compose.material3.MaterialTheme.colorScheme.onPrimary
            else -> Color.LightGray
        },
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(
            width = 1.dp,
            color = when {
                selected -> androidx.compose.material3.MaterialTheme.colorScheme.primary
                else -> Color.LightGray
            }
        ),
        modifier = modifier
    ) {
        Row(modifier = Modifier) {
            Image(
                painter = painterResource(imageId),
                contentDescription = null,
                modifier = Modifier
                    .padding(8.dp)
                    .size(20.dp)
                    .clip(CircleShape)
            )
            Text(
                text = text,
                style = typography.bodyMedium,
                modifier = Modifier.padding(end = 8.dp, top = 8.dp, bottom = 8.dp)
            )
        }
    }
}