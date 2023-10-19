package com.polendina.mustudentportal.loginpage

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.focus.FocusRequester
import androidx.lifecycle.ViewModel
import com.polendina.mustudentportal.ui.loginpage.LoginViewModel

// todo: Extraneous explicit property accessors, and private fields is just a placeholder, till I (potentially) configure a custom implementation for them
class LoginViewModelImpl: LoginViewModel, ViewModel() {

    private var _openBottomSheet: Boolean by mutableStateOf(false)
    private var _selectedUniversity: University by mutableStateOf(University(String(), String(), String(), String()))
    private var _creditHourChecked: Boolean by mutableStateOf(false)
    private var _academicYearChecked: Boolean by mutableStateOf(false)
    private var _passwordVisibility: Boolean by mutableStateOf(true)
    private var _userName: String by mutableStateOf(String())
    private var _userPassword: String by mutableStateOf(String())
    private var _universitySearchBarQuery: String by mutableStateOf(String())
    private var _searchBarActive: Boolean by mutableStateOf(false)
    private var _universitiesList: List<University> by mutableStateOf(emptyList())
    private var _universitiesLoaded: Boolean by mutableStateOf(false)

    override var openBottomSheet
        get() = _openBottomSheet
        set(value) { _openBottomSheet = value }

    override var selectedUniversity
        get() = _selectedUniversity
        set(value) { _selectedUniversity = value }
    override var creditHourChecked
        get() = _creditHourChecked
        set(value) { _creditHourChecked = value }
    override var creditHourEnabled: Boolean
        get() = selectedUniversity.creditHour.isNotEmpty()
        set(value) {}
    override var academicYearChecked: Boolean
        get() = _academicYearChecked
        set(value) { _academicYearChecked = value }
    override var academicYearEnabled
        get() = selectedUniversity.academicYear.isNotEmpty()
        set(value) {}
    override var passwordVisibility
        get() = _passwordVisibility
        set(value) { _passwordVisibility = value }
    override var userName
        get() = _userName
        set(value) { _userName = value }
    override var userPassword
        get() = _userPassword
        set(value) { _userPassword = value }
    override var universitySearchBarQuery
        get() = _universitySearchBarQuery
        set(value) { _universitySearchBarQuery = value }
    override var searchBarActive
        get() = _searchBarActive
        set(value) { _searchBarActive = value }
    override var universitiesList
        get() = _universitiesList
        set(value) { _universitiesList = value }
    override var universitiesLoaded
        get() = _universitiesLoaded
        set(value) { universitiesLoaded = value }
    override var nationalIdFocusRequester: FocusRequester
        get() = FocusRequester()
        set(value) {}
    override var passwordFocusRequester: FocusRequester
        get() = FocusRequester()
        set(value) {}

    override fun onUserNameChange(newName: String) {
        _userName = newName
    }

    override fun onUserPasswordChange(newPassword: String) {
        _userPassword = newPassword
    }
    override fun onSignIn() { }
    override fun onCreditHourRadioButtonClicked() {
        creditHourChecked = !creditHourChecked
        if (academicYearChecked) { academicYearChecked = false }
    }
    override fun onAcademicYearRadioButtonClicked() {
        academicYearChecked = !academicYearChecked
        if (creditHourChecked) { creditHourChecked = false }
    }
    override fun passwordImageVectorOnClick() {
        passwordVisibility = !passwordVisibility
    }
}