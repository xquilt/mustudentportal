package com.polendina.mustudentportal.ui.page.components

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import com.polendina.mustudentportal.ui.theme.MUStudentPortalTheme

@Composable
fun DisplayHeader(
    modifier: Modifier = Modifier,
    header: String,
    description: String
) {
    Column (
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(
            text = header,
            color = MaterialTheme.colorScheme.onSurface,
            style = MaterialTheme.typography.displayMedium
        )
        AnimatedVisibility(visible = description.isNotEmpty()) {
            Text(
                text = description,
                maxLines = 1,
                color = MaterialTheme.colorScheme.outline,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Preview(showBackground = true, device = Devices.NEXUS_5, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(showBackground = true, device = Devices.NEXUS_5, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun DisplayHeaderPreview(
) {
    MUStudentPortalTheme {
        var description: String by remember { mutableStateOf("") }
        Scaffold {
            DisplayHeader(
                header = "Pronunciations",
                description = description,
                modifier = Modifier.padding(it)
            )
        }
        // TODO: Should schedule the assignment of this value to take some time so that I can notice the animation taking place!
        description = LoremIpsum(40).values.joinToString()
    }
}
