package com.polendina.mustudentportal.ui.loginpage

import androidx.compose.ui.focus.FocusRequester
import com.polendina.mustudentportal.loginpage.University

interface LoginViewModel {
    var openBottomSheet: Boolean
    var selectedUniversity: University
    var creditHourChecked: Boolean
    var creditHourEnabled: Boolean
    var academicYearChecked: Boolean
    var academicYearEnabled: Boolean
    var passwordVisibility: Boolean
    var userName: String
    var userPassword: String
    var universitySearchBarQuery:String
    var searchBarActive: Boolean
    var universitiesList: List<University>
    var universitiesLoaded: Boolean
    var nationalIdFocusRequester: FocusRequester
    var passwordFocusRequester: FocusRequester
    fun onUserNameChange(newName: String)
    fun onUserPasswordChange(newPassword: String)
    fun onSignIn()
    fun onCreditHourRadioButtonClicked()
    fun onAcademicYearRadioButtonClicked()
    fun passwordImageVectorOnClick()
}