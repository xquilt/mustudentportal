package com.polendina.mustudentportal.ui.loginpage

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.focus.FocusRequester
import com.polendina.mustudentportal.loginpage.University
import com.polendina.mustudentportal.loginpage.universities

class LoginViewModelMock: LoginViewModel {
    private var _openBottomSheet: Boolean by mutableStateOf(false)
    private var _selectedUniversity: University by mutableStateOf<University>(University(String(), String(), String(), String()))
    private var _creditHourChecked: Boolean by mutableStateOf(false)
    private var _academicYearChecked: Boolean by mutableStateOf(false)
    private var _passwordVisibility: Boolean by mutableStateOf(true)
    private var _userName: String by mutableStateOf(String())
    private var _userPassword: String by mutableStateOf(String())
    private var _universitySearchBarQuery: String by mutableStateOf(String())
    private var _searchBarActive: Boolean by mutableStateOf(false)
    private var _universitiesList: List<University> by mutableStateOf(universities)
    private var _universitiesLoaded: Boolean by mutableStateOf(true)
    override var openBottomSheet: Boolean
        get() = _openBottomSheet
        set(value) {}
    override var selectedUniversity: University
        get() = _selectedUniversity
        set(value) {}
    override var creditHourChecked: Boolean
        get() = _creditHourChecked
        set(value) {}
    override var creditHourEnabled: Boolean
        get() = selectedUniversity.creditHour.isNotEmpty()
        set(value) {}
    override var academicYearChecked: Boolean
        get() = _academicYearChecked
        set(value) {}
    override var academicYearEnabled: Boolean
        get() = selectedUniversity.academicYear.isNotEmpty()
        set(value) {}
    override var passwordVisibility: Boolean
        get() = _passwordVisibility
        set(value) {}
    override var userName: String
        get() = _userName
        set(value) {}
    override var userPassword: String
        get() = _userPassword
        set(value) {}
    override var universitySearchBarQuery: String
        get() = _universitySearchBarQuery
        set(value) {}
    override var searchBarActive: Boolean
        get() = _searchBarActive
        set(value) {}
    override var universitiesList: List<University>
        get() = _universitiesList
        set(value) {}
    override var universitiesLoaded: Boolean
        get() = _universitiesLoaded
        set(value) {}
    override var nationalIdFocusRequester: FocusRequester
        get() = FocusRequester()
        set(value) {}
    override var passwordFocusRequester: FocusRequester
        get() = FocusRequester()
        set(value) {}
    override fun onUserNameChange(newName: String) {
        userName = newName
    }
    override fun onUserPasswordChange(newPassword: String) {
        userPassword = newPassword
    }
    override fun onSignIn() {}
    override fun onAcademicYearRadioButtonClicked(){
        academicYearChecked = !academicYearChecked
        if (creditHourChecked) { creditHourChecked = false }
    }
    override fun onCreditHourRadioButtonClicked() {
        creditHourChecked = !creditHourChecked
        if (academicYearChecked) { academicYearChecked = false }
    }
    override fun passwordImageVectorOnClick() {
        passwordVisibility = !passwordVisibility
    }
}

