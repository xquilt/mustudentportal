package com.polendina.mustudentportal.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DarkMode
import androidx.compose.material.icons.rounded.LightMode
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.polendina.mustudentportal.ui.theme.MUStudentPortalTheme

@Composable
fun NavigationDrawerLightMode(
    modifier: Modifier = Modifier,
    lightMode: Boolean,
    onClick: (Boolean) -> Unit
) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .padding(horizontal = 10.dp)
    ) {
        ElementThis(
            title = "Light",
            icon = Icons.Rounded.LightMode,
            selected = lightMode,
            modifier = Modifier
                .fillMaxHeight(0.9f)
                .fillMaxSize(0.5f)
        ) {
            onClick(true)
        }
        ElementThis(
            title = "Dark",
            icon = Icons.Outlined.DarkMode,
            selected = !lightMode,
            modifier = Modifier
                .fillMaxHeight(0.9f)
                .fillMaxWidth(1f)
        ) {
            onClick(false)
        }
    }
}

@Composable
fun ElementThis(
    modifier: Modifier = Modifier,
    title: String,
    icon: ImageVector,
    selected: Boolean,
    onClick: () -> Unit
) {
    Row (
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .clip(CircleShape)
            .background(
                if (selected) MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.5f) else Color.Unspecified
            )
//            .shadow(elevation = if (selected) 1.dp else 0.dp, shape = CircleShape)
            .clickable { onClick() }
    ) {
        Icon(
            imageVector = icon,
            contentDescription = title,
            tint = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
        )
        Text(
            text = title,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
        )
    }
}

@Preview(showBackground = true, )
@Composable
fun ToggleThis() {
    MUStudentPortalTheme {
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
        ) {
            var lightMode by remember { mutableStateOf(true) }
            NavigationDrawerLightMode(
                lightMode = lightMode,
            ) {
                lightMode = it
            }
        }
    }
}