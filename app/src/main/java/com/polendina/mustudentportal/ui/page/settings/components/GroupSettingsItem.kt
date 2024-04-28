import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Language
import androidx.compose.material.icons.outlined.Lightbulb
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.res.stringResource
import com.polendina.mustudentportal.R

@Composable
fun GroupSettingsItem(
    modifier: Modifier = Modifier,
    groupSettingsItem: GroupSettingsItem,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = if (isSelected) MaterialTheme.colorScheme.onSurface else MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(20.dp)
            )
            .padding(vertical = 20.dp)
            .clickable { onClick.invoke() }
    ) {
        groupSettingsItem.icon?.let {
            Icon(
                imageVector = groupSettingsItem.icon,
                contentDescription = stringResource(id = groupSettingsItem.title),
                modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                tint = if (isSelected) MaterialTheme.colorScheme.surfaceVariant else MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        Column (
        ) {
            Text(
                text = stringResource(id = groupSettingsItem.title),
                maxLines = 1,
                color = if (isSelected) MaterialTheme.colorScheme.surface else MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.titleLarge.copy(fontSize = 20.sp)
            )
            groupSettingsItem.description?.let {
                Text(
                    text = stringResource(id = groupSettingsItem.description),
                    maxLines = 1,
                    color = if (isSelected) MaterialTheme.colorScheme.surface.copy(alpha = 0.4f) else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

enum class GroupSettingsItem(
    @StringRes val title: Int,
    @StringRes val description: Int?,
    val icon: ImageVector?,
    val callback: () -> Unit
) {
    ACCOUNT(title = R.string.account, description = R.string.account_description, icon = Icons.Outlined.AccountCircle, callback = {}),
    CONFIGURATION(title = R.string.configuration, description = R.string.configuration_description, icon = Icons.Outlined.Settings, callback = {}),
    STYLING(title = R.string.styling, description = R.string.styling_description, icon = Icons.Outlined.Lightbulb, callback = {}),
    LANGUAGE(title = R.string.language, description = R.string.account_description, icon = Icons.Outlined.Language, callback = {}),
    SUPPORT(title = R.string.support, description = R.string.account_description, icon = Icons.Outlined.AccountCircle, callback = {}),
}