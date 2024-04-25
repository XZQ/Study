package com.xzq.composestudy.drawer

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.xzq.composestudy.R
import com.xzq.composestudy.navigation.NaviGraph


@Composable
fun AppDrawer(
    currentRoute: String,
    navigateHome: () -> Unit,
    navigateToInterests: () -> Unit,
    closeDrawer: () -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(Modifier.height(24.dp))
        StudyLogo(Modifier.height(16.dp))
        Divider(color = androidx.compose.material.MaterialTheme.colors.onSurface.copy(alpha = .2f))
        DrawerButton(
            icon = Icons.Filled.Home,
            label = "Home",
            isSelect = currentRoute == NaviGraph.HOME_ROUTE,
            action = {
                navigateHome()
                closeDrawer()
            }
        )
        DrawerButton(
            icon = Icons.Filled.Add,
            label = "Interests",
            isSelect = currentRoute == NaviGraph.INTERESTS_ROUTE,
            action = {
                navigateToInterests()
                closeDrawer()
            }
        )
    }
}

@Composable
fun DrawerButton(icon: ImageVector, label: String, isSelect: Boolean, action: () -> Unit, modifier: Modifier = Modifier) {
    val colors = androidx.compose.material.MaterialTheme.colors
    val imageAlpha = if (isSelect) 1F else 0.6F
    val textIconColor = if (isSelect) colors.primary else colors.onSurface.copy(alpha = 0.6F)
    val background = if (isSelect) colors.primary.copy(alpha = 0.12F) else Color.Transparent
    val surfaceModifier = modifier.padding(start = 8.dp, top = 8.dp, end = 8.dp)

    Surface(
        modifier = surfaceModifier,
        color = background,
        shape = MaterialTheme.shapes.small
    ) {
        TextButton(onClick = action, modifier = Modifier.fillMaxWidth()) {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    imageVector = icon,
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(textIconColor),
                    alpha = imageAlpha
                )
                Spacer(Modifier.width(16.dp))
                Text(
                    text = label,
                    style = androidx.compose.material.MaterialTheme.typography.body2,
                    color = textIconColor
                )
            }
        }
    }
}

@Composable
fun StudyLogo(modifier: Modifier = Modifier) {
    Row(modifier = modifier) {
        Image(
            modifier = Modifier.size(22.dp),
            painter = painterResource(id = R.drawable.cupcake),
            contentDescription = null,
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface)
        )
        Spacer(Modifier.width(8.dp))
        Image(
            painter = painterResource(R.drawable.ic_github_square_brands),
            contentDescription = null,
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface)
        )
    }
}
