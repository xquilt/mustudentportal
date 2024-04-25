package com.polendina.mustudentportal.loginpage

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.polendina.mustudentportal.ui.loginpage.LoginViewModel
import com.polendina.mustudentportal.ui.loginpage.LoginViewModelMock
import com.polendina.mustudentportal.ui.theme.MUStudentPortalTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPage(
    navController: NavController?,
    loginViewModel: LoginViewModel = viewModel()
) {
    val coroutineScope = rememberCoroutineScope()
    val bottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = false)
    val focusManager = LocalFocusManager.current

    LoginPageForum(
        loginViewModel = loginViewModel,
        onSelectUniversity = {
            loginViewModel.openBottomSheet = true
            coroutineScope.launch {
                bottomSheetState.expand()
            }
        },
        onNext = {
            loginViewModel.passwordFocusRequester.requestFocus()
        },
        onDone = {
            focusManager.clearFocus()
        }
    )
    // TODO: I guess we can rely on bottomSheet internal states to determine the bottom sheet expansion state.
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
private fun LoginPreview() {
    MUStudentPortalTheme {
        Surface (
            modifier = Modifier
                .fillMaxSize()
        ) {
            LoginPage(
                loginViewModel = LoginViewModelMock(),
                navController = null
            )
        }
    }
}