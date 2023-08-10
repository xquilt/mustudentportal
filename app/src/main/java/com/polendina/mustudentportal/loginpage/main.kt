package com.polendina.mustudentportal.loginpage

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.polendina.mustudentportal.ui.theme.MUStudentPortalTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainLogin(
    navController: NavController?,
    loginViewModel: LoginViewModel = viewModel()
) {

    val coroutineScope = rememberCoroutineScope()
    val bottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = false)
    val focusManager = LocalFocusManager.current
    val nationalIdFocusRequester by remember { mutableStateOf (FocusRequester()) }
    val passwordFocusRequester by remember { mutableStateOf(FocusRequester()) }
    val context = LocalContext.current

    LoginPage(
        userName = loginViewModel.userName,
        onUserNameChange = {
            loginViewModel.userName = it
        },
        userPassword = loginViewModel.userPassword,
        onUserPasswordChange = {
            loginViewModel.userPassword = it
        },
        onSignIn = { /*TODO*/ },
        academicYearEnabled = loginViewModel.selectedUniversity.academicYear.isNotEmpty(),
        academicYearChecked = loginViewModel.academicYearChecked,
        creditHourEnabled = loginViewModel.selectedUniversity.creditHour.isNotEmpty(),
        creditHourChecked = loginViewModel.creditHourChecked,
        onAcademicYearRadioButtonClicked = {
            loginViewModel.academicYearChecked = !loginViewModel.academicYearChecked
            if (loginViewModel.creditHourChecked) { loginViewModel.creditHourChecked = false }
        },
        onCreditHourRadioButtonClicked = {
            loginViewModel.creditHourChecked = !loginViewModel.creditHourChecked
            if (loginViewModel.academicYearChecked) { loginViewModel.academicYearChecked = false }
        },
        onSelectUniversity = {
            loginViewModel.openBottomSheet = true
            coroutineScope.launch {
                bottomSheetState.show()
            }
        },
        passwordVisibility = loginViewModel.passwordVisibility,
        passwordImageVectorOnClick = {
            loginViewModel.passwordVisibility = !loginViewModel.passwordVisibility
        },
        onNext = {
            passwordFocusRequester.requestFocus()
        },
        onDone = {
            focusManager.clearFocus()
        },
        nationalIdFocusRequester = nationalIdFocusRequester,
        passwordFocusRequester = passwordFocusRequester
    )
    if (loginViewModel.openBottomSheet) {
        UniversitiesBottomSheet(
            bottomSheetState = bottomSheetState,
            universities = loginViewModel.universitiesList,
            universitySearchBarQuery = loginViewModel.universitySearchBarQuery,
            onUniversiteQueryChange = {
                loginViewModel.universitySearchBarQuery = it
                loginViewModel.universitiesList = universities
            },
            onSearch = {
                loginViewModel.searchBarActive = false
                loginViewModel.universitiesList = loginViewModel.universitiesList.filter { university ->  university.name.contains(it) }
            },
            selectedUniversity = loginViewModel.selectedUniversity,
            onSelectingUniversity = {
                loginViewModel.selectedUniversity = it
                loginViewModel.academicYearChecked = false
                loginViewModel.creditHourChecked = false
            },
            onDismissRequest = {
                coroutineScope.launch {
                    bottomSheetState.hide()
                }.invokeOnCompletion {
                    loginViewModel.openBottomSheet = false
                }
            },
            searchBarActive = loginViewModel.searchBarActive,
            onSearchBarActiveChange = {
                loginViewModel.searchBarActive = it
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainLogin() {
    MUStudentPortalTheme() {
        MainLogin(
            navController = null
        )
    }
}