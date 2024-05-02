package com.polendina.mustudentportal.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.polendina.mustudentportal.R
import com.polendina.mustudentportal.domain.model.NavigationItem
import com.polendina.mustudentportal.ui.theme.MUStudentPortalTheme


// TODO: Check the user email being valid or not!
data class UserEmail(private val email: String) {
    override fun toString(): String {
        return email
    }
}

// TODO: Move it elsewhere in accordance with clean architecture
data class User(
    val name: String,
    val email: UserEmail
)

@Composable
@OptIn(ExperimentalMaterial3Api::class, ExperimentalStdlibApi::class)
fun NavigationDrawerWhole() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Open)
    var selectedItemIndex by rememberSaveable { mutableIntStateOf(0) }
    val user = User(name = "Linus Torvalds", email = UserEmail("linus@linuxfoundation.org"))
    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            vertical = 20.dp,
                            horizontal = 15.dp
                        )
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.surfaceVariant)
                            .align(Alignment.CenterVertically)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_person),
                            contentDescription = null
                        )
                    }
                    Column {
                        Text(
                            text = user.name,
                            style = MaterialTheme.typography.titleMedium,
                        )
                        Text(
                            text = user.email.toString(),
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
                Divider(
                    modifier = Modifier
                        .padding(vertical = 10.dp)
                        .height(1.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(90.dp))
                )
                NavigationItem.values().forEachIndexed { index, navigationItem ->
                    NavigationItemView(
                        navigationItem = navigationItem,
                        selected = selectedItemIndex == index,
                        onClick = {
                            selectedItemIndex = index
                        }
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Divider(modifier = Modifier.padding(10.dp))
                Column (
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(bottom = 10.dp)
                ) {
                    Row (
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(start = 20.dp, end = 20.dp, bottom = 10.dp)
                            .height(40.dp)
                            .fillMaxWidth()
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Info,
                            contentDescription = stringResource(id = R.string.color_scheme),
                            tint = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
                            modifier = Modifier
                                .padding(end = 10.dp)
                        )
                        Text(
                            text = stringResource(id = R.string.color_scheme),
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                        )
                    }
                    var lightMode by remember { mutableStateOf(true) }
                    NavigationDrawerLightMode(
                        lightMode = lightMode,
                        modifier = Modifier
                            .height(40.dp)
    //                    .width(150.dp)
                            .fillMaxWidth(0.9f)
                    ) {
                        lightMode = it
                    }
                }
            }
        },
        drawerState = drawerState
    ) {
        Scaffold (
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "Hello world!")
                    },
                    navigationIcon = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Menu")
                        }
                    }
                )
            },
        ) {
            it
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(showBackground = true, device = Devices.PIXEL_4, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun Just() {
    MUStudentPortalTheme {
        NavigationDrawerWhole()
    }
}