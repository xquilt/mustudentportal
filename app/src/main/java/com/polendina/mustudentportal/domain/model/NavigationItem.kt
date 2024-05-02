package com.polendina.mustudentportal.domain.model

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material.icons.rounded.CalendarMonth
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.icons.rounded.Star
import androidx.compose.ui.graphics.vector.ImageVector
import com.polendina.mustudentportal.R

enum class NavigationItem(
    @StringRes val title: Int,
    val icon: ImageVector,
    val badgeCount: Int? = null,
) {
    Home(
        title = R.string.home,
        icon = Icons.Rounded.Home
    ),
    Schedule(
        title = R.string.schedule,
        icon = Icons.Rounded.CalendarMonth
    ),
    Notifications(
        title = R.string.notifications,
        icon = Icons.Rounded.Notifications,
        badgeCount = 20
    ),
    Address(
        title = R.string.address,
        icon = Icons.Rounded.LocationOn,
    ),
    Rewards(
        title = R.string.rewards,
        icon = Icons.Rounded.Star,
        badgeCount = 13
    ),
    Settings(
        title = R.string.settings,
        icon = Icons.Rounded.Settings
    ),
    Support(
        title = R.string.support,
        icon = Icons.Outlined.Phone,
    ),
}
