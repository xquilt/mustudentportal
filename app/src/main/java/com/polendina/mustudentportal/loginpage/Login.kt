package com.polendina.mustudentportal.loginpage

import Shapes
import android.database.sqlite.SQLiteDoneException
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActionScope
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.filled.AssignmentInd
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusOrder
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.polendina.mustudentportal.R
import com.polendina.mustudentportal.ui.theme.MUStudentPortalTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPage(
    userName: String,
    onUserNameChange: (String) -> Unit,
    userPassword: String,
    onUserPasswordChange: (String) -> Unit,
    onSignIn: () -> Unit,
    onSelectUniversity: () -> Unit,
    academicYearEnabled: Boolean,
    academicYearChecked: Boolean,
    creditHourEnabled: Boolean,
    creditHourChecked: Boolean,
    onCreditHourRadioButtonClicked: () -> Unit,
    onAcademicYearRadioButtonClicked: () -> Unit,
    passwordVisibility: Boolean,
    passwordImageVectorOnClick: () -> Unit,
    onNext: (KeyboardActionScope) -> Unit,
    onDone: (KeyboardActionScope) -> Unit,
    nationalIdFocusRequester: FocusRequester,
    passwordFocusRequester: FocusRequester,
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
            value = userName,
            label = {
                Text(text = stringResource(id = R.string.user_name))
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Number
            ),
            keyboardActions = KeyboardActions(
                onNext = onNext
            ),
            onValueChange = onUserNameChange,
            imageVector = Icons.Default.AssignmentInd,
            imageVectorOnClick = { },
            visualTransformation = VisualTransformation.None,
            focusRequester = nationalIdFocusRequester
        )
        InputField(
            value = userPassword,
            label = {
                Text(text = stringResource(id = R.string.password))
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Password
            ),
            onValueChange = onUserPasswordChange,
            imageVector = Icons.Default.RemoveRedEye,
            imageVectorOnClick = passwordImageVectorOnClick,
            visualTransformation = if (passwordVisibility) PasswordVisualTransformation() else VisualTransformation.None,
            keyboardActions = KeyboardActions(
                onDone = onDone
            ),
            focusRequester = passwordFocusRequester
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


/**
 * A unified wrapper around TextField to have a consistent theme.
 *
 * @param imageVector The icon of the trailingIcon of the TextField.
 * @param imageVectorOnClick A callback function, when the user clicks on the trailing icon.
 */
@Composable
fun InputField(
    value: String,
    label: @Composable () -> Unit,
    keyboardOptions: KeyboardOptions,
    keyboardActions: KeyboardActions,
    onValueChange: (String) -> Unit,
    imageVector: ImageVector,
    imageVectorOnClick: () -> Unit,
    visualTransformation: VisualTransformation,
    focusRequester: FocusRequester,
    modifier: Modifier = Modifier
) {
    TextField(
        value = value,
        label = label,
        onValueChange = onValueChange,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        shape = Shapes.small,
        colors = TextFieldDefaults.colors(
//                focusedContainerColor = containerColor,
//                unfocusedContainerColor = containerColor,
//                disabledContainerColor = containerColor,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        visualTransformation = visualTransformation,
        trailingIcon = {
           IconButton(
               onClick = imageVectorOnClick
           ) {
               Icon(
                   imageVector = imageVector,
                   contentDescription =  null
               )
           }
        },
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .focusRequester(focusRequester = focusRequester)
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
            val selectedUniversity: University = universities[0]
            var passwordVisibility: Boolean = true
            LoginPage(
                userName = "",
                onUserNameChange = {},
                userPassword = "",
                onUserPasswordChange = {},
                onSignIn = {},
                onSelectUniversity = {},
                academicYearEnabled = selectedUniversity.academicYear.isNotEmpty(),
                academicYearChecked = false,
                creditHourEnabled = selectedUniversity.creditHour.isNotEmpty(),
                creditHourChecked = false,
                onAcademicYearRadioButtonClicked = { },
                passwordVisibility = passwordVisibility,
                onCreditHourRadioButtonClicked = { },
                passwordImageVectorOnClick = {
                    passwordVisibility = !passwordVisibility
                },
                onNext = {},
                onDone = {},
                nationalIdFocusRequester = FocusRequester(),
                passwordFocusRequester = FocusRequester()
            )
        }
    }
}