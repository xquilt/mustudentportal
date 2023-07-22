package com.polendina.mustudentportal.loginpage

import Shapes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.polendina.mustudentportal.R
import com.polendina.mustudentportal.ui.theme.MUStudentPortalTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPage(
    onUserNameChange: (String) -> Unit,
    onUserPasswordChange: (String) -> Unit,
    onSignIn: () -> Unit,
    onSelectUniversity: () -> Unit,
    academicYearEnabled: Boolean,
    academicYearChecked: Boolean,
    creditHourEnabled: Boolean,
    creditHourChecked: Boolean,
    onCreditHourRadioButtonClicked: () -> Unit,
    onAcademicYearRadioButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(space = 20.dp, alignment = Alignment.Bottom),
        modifier = Modifier
            .padding(24.dp)
            .fillMaxSize()
    ) {
        Icon(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier
                .size(200.dp)
        )
        InputField(
            value = stringResource(id = R.string.user_name),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            onValueChange = onUserNameChange,
        )
        InputField(
            value = stringResource(id = R.string.password),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            onValueChange = onUserPasswordChange,
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = stringResource(id = R.string.academic_year),
                color = if (academicYearEnabled) Color.Black else Color.Gray
            )
            RadioButton(
                enabled = academicYearEnabled,
                selected = academicYearChecked,
                onClick = onAcademicYearRadioButtonClicked
            )
            Text(
                text = stringResource(id = R.string.credit_hour),
                color = if (creditHourEnabled) Color.Black else Color.Gray
            )
            RadioButton(
                enabled = creditHourEnabled,
                selected = creditHourChecked,
                onClick = onCreditHourRadioButtonClicked
            )
        }
        Button(
            onClick = onSignIn,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = stringResource(id = R.string.sign_in),
                modifier = Modifier
                    .padding(vertical = 10.dp)
            )
        }
        Divider()
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = stringResource(id = R.string.unselected_university))
            TextButton(
                onClick = onSelectUniversity
            ) {
                Text(text = stringResource(id = R.string.select_college))
            }
        }
    }
}

@Composable
fun InputField(
    value: String,
    keyboardOptions: KeyboardOptions,
    onValueChange: (String) -> Unit
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        keyboardOptions = keyboardOptions,
        shape = Shapes.small,
        colors = TextFieldDefaults.colors(
//                focusedContainerColor = containerColor,
//                unfocusedContainerColor = containerColor,
//                disabledContainerColor = containerColor,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
    )
}

@Preview(showBackground = true)
@Composable
private fun GreetingPreview() {
    MUStudentPortalTheme {
        Surface (
            modifier = Modifier
                .fillMaxSize()
        ) {
            val selectedUniversity: University = univerisities[0]
            LoginPage(
                onUserNameChange = {},
                onUserPasswordChange = {},
                onSignIn = {},
                onSelectUniversity = {},
                academicYearEnabled = selectedUniversity.academicYear.isNotEmpty(),
                academicYearChecked = false,
                creditHourEnabled = selectedUniversity.creditHour.isNotEmpty(),
                creditHourChecked = false,
                onAcademicYearRadioButtonClicked = { },
                onCreditHourRadioButtonClicked = { }
            )
        }
    }
}