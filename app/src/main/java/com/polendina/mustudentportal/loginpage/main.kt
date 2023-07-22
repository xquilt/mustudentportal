package com.polendina.mustudentportal.loginpage

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.polendina.mustudentportal.ui.theme.MUStudentPortalTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainLogin() {
    var openBottomSheet by rememberSaveable { mutableStateOf(false) }
    val bottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = false)
    val coroutineScope = rememberCoroutineScope()
    var selectedUniversity: University by remember { mutableStateOf(University(String(), String(), String(), String())) }
    var creditHourChecked by remember { mutableStateOf(false) }
    var academicYearChecked by remember { mutableStateOf(false) }
    LoginPage(
        onUserNameChange = {},
        onUserPasswordChange = {},
        onSignIn = { /*TODO*/ },
        academicYearEnabled = selectedUniversity.academicYear.isNotEmpty(),
        academicYearChecked = academicYearChecked,
        creditHourEnabled = selectedUniversity.creditHour.isNotEmpty(),
        creditHourChecked = creditHourChecked,
        onAcademicYearRadioButtonClicked = {
            academicYearChecked = !academicYearChecked
            if (creditHourChecked) { creditHourChecked = false }
        },
        onCreditHourRadioButtonClicked = {
            creditHourChecked = !creditHourChecked
            if (academicYearChecked) { academicYearChecked = false }
        },
        onSelectUniversity = {
            openBottomSheet = true
            coroutineScope.launch {
                bottomSheetState.show()
            }
        }
    )
    if (openBottomSheet) {
        UniversitiesBottomSheet(
            bottomSheetState = bottomSheetState,
            universities = univerisities,
            onQueryChange = {},
            onSearch = {},
            selectedUniversity = selectedUniversity,
            onSelectingUniversity = {
                selectedUniversity = it
                academicYearChecked = false
                creditHourChecked = false
            },
            onDismissRequest = {
                coroutineScope.launch {
                    bottomSheetState.hide()
                }.invokeOnCompletion {
                    openBottomSheet = false
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainLogin() {
    MUStudentPortalTheme() {
        MainLogin()
    }
}