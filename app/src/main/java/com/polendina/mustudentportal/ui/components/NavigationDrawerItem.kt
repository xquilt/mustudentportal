package com.polendina.mustudentportal.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.polendina.mustudentportal.domain.model.NavigationItem
import com.polendina.mustudentportal.ui.theme.MUStudentPortalTheme

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun NavigationItemView(
    navigationItem: NavigationItem,
    selected: Boolean,
    onClick: () -> Unit
) {
    NavigationDrawerItem(
        colors = NavigationDrawerItemDefaults.colors(
            selectedContainerColor = MaterialTheme.colorScheme.onSurface,
            unselectedContainerColor = MaterialTheme.colorScheme.surface,
            selectedTextColor = MaterialTheme.colorScheme.surface,
            unselectedTextColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
            selectedIconColor = MaterialTheme.colorScheme.surface,
            unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f)
        ),
        label = {
            Text(
                text = stringResource(id = navigationItem.title),
                style = MaterialTheme.typography.labelMedium,
            )
        },
        icon = {
            Icon(
                imageVector = navigationItem.icon,
                contentDescription = stringResource(id = navigationItem.title)
            )
        },
        selected = selected,
        onClick = onClick,
        badge = {
            navigationItem.badgeCount?.let { badgeCount ->
                Badge(
                ) {
                    Text(
                        text = badgeCount.toString(),
                        modifier = Modifier.padding(5.dp)
                    )
                }
            }
        },
        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
    )
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun NavigationItemViewPreview() {
    MUStudentPortalTheme {
        Column (
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .height(90.dp),
        ) {
            NavigationItemView(
                navigationItem = NavigationItem.Notifications,
                selected = false,
                onClick = { }
            )
        }
    }
}