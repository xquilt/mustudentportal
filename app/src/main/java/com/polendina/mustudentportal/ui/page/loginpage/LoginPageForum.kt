package com.polendina.mustudentportal.loginpage

import InputField
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActionScope
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AssignmentInd
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.polendina.mustudentportal.R
import com.polendina.mustudentportal.ui.loginpage.LoginViewModel
import com.polendina.mustudentportal.ui.loginpage.LoginViewModelMock
import com.polendina.mustudentportal.ui.theme.MUStudentPortalTheme

@Composable
fun LoginPageForum(
    loginViewModel: LoginViewModel,
    onNext: (KeyboardActionScope) -> Unit,
    onDone:  (KeyboardActionScope) -> Unit,
    onSelectUniversity: () -> Unit,
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
            value = loginViewModel.userName,
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
            onValueChange = {
                loginViewModel.onUserNameChange(it)
            },
            imageVector = Icons.Default.AssignmentInd,
            imageVectorOnClick = { },
            visualTransformation = VisualTransformation.None,
            focusRequester = loginViewModel.nationalIdFocusRequester
        )
        InputField(
            value = loginViewModel.userPassword,
            label = {
                Text(text = stringResource(id = R.string.password))
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Password
            ),
            onValueChange = {
                loginViewModel.onUserPasswordChange(it)
            },
            imageVector = Icons.Default.RemoveRedEye,
            imageVectorOnClick = {
                loginViewModel.passwordImageVectorOnClick()
            },
            visualTransformation = if (loginViewModel.passwordVisibility) PasswordVisualTransformation() else VisualTransformation.None,
            keyboardActions = KeyboardActions(
                onDone = onDone
            ),
            focusRequester = loginViewModel.passwordFocusRequester
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = stringResource(id = R.string.academic_year),
                color = if (loginViewModel.academicYearEnabled) Color.Black else Color.Gray
            )
            RadioButton(
                enabled = loginViewModel.academicYearEnabled,
                selected = loginViewModel.academicYearChecked,
                onClick = {
                    loginViewModel.onAcademicYearRadioButtonClicked()
                }
            )
            Text(
                text = stringResource(id = R.string.credit_hour),
                color = if (loginViewModel.creditHourChecked) Color.Black else Color.Gray
            )
            RadioButton(
                enabled = loginViewModel.creditHourEnabled,
                selected = loginViewModel.creditHourChecked,
                onClick = {
                    loginViewModel.onCreditHourRadioButtonClicked()
                }
            )
        }
        Button(
            onClick = {
                loginViewModel.onSignIn()
            },
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

@Preview(showBackground = true)
@Composable
fun PreviewMainLogin() {
    MUStudentPortalTheme() {
        LoginPage(
            loginViewModel = LoginViewModelMock(),
            navController = null
        )
    }
}