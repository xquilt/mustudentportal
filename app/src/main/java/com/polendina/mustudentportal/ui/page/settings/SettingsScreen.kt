package com.polendina.mustudentportal.ui.page.settings

import GroupSettingsItem
import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.polendina.mustudentportal.R
import com.polendina.mustudentportal.ui.page.components.DisplayHeader
import com.polendina.mustudentportal.ui.theme.MUStudentPortalTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SettingsScreen(
    modifier: Modifier = Modifier
) {
    // TODO: Swap us after testing!
    //    var selectedGroupSettingsItem by remember { mutableIntStateOf(-1) }
    var selectedGroupSettingsItem by remember { mutableIntStateOf(0) }
    Scaffold (
        topBar = {
            TopAppBar(
                title = { },
                navigationIcon = {
                    Icon(imageVector = Icons.Rounded.ArrowBack, contentDescription = null)
                }
            )
        }
    ) {
        Column (
            modifier = Modifier
                .padding(it)
                .padding(
                    horizontal = 10.dp
                )
        ) {
            DisplayHeader(
                header = stringResource(id = R.string.settings),
                description = "",
                modifier = Modifier
                    .padding(
                        vertical = 20.dp,
                        horizontal = 10.dp
                    )
            )
            GroupSettingsItem.values().forEachIndexed { index, groupSettingsItem ->
                GroupSettingsItem(
                    groupSettingsItem = groupSettingsItem,
                    isSelected = index == selectedGroupSettingsItem,
                    onClick = {
                        selectedGroupSettingsItem = index
                    },
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(showBackground = true, device = Devices.PIXEL_4, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun SettingsScreenPreview(
    modifier: Modifier = Modifier
) {
    // TODO: Swap us after testing!
//    var selectedGroupSettingsItem by remember { mutableIntStateOf(-1) }
    MUStudentPortalTheme {
        SettingsScreen()
    }
}