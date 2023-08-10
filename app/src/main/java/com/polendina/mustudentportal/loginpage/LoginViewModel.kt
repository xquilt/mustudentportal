package com.polendina.mustudentportal.loginpage

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.focus.FocusRequester
import androidx.lifecycle.ViewModel

// todo: Extraneous explicit property accessors, and private fields is just a placeholder, till I (potentially) configure a custom implementation for them
class LoginViewModel: ViewModel() {

    private var _openBottomSheet: Boolean by mutableStateOf(false)
    private var _selectedUniversity: University by mutableStateOf(University(String(), String(), String(), String()))
    private var _creditHourChecked: Boolean by mutableStateOf(false)
    private var _academicYearChecked: Boolean by mutableStateOf(false)
    private var _passwordVisibility: Boolean by mutableStateOf(true)
    private var _userName: String by mutableStateOf(String())
    private var _userPassword: String by mutableStateOf(String())
    private var _universitySearchBarQuery: String by mutableStateOf(String())
    private var _searchBarActive: Boolean by mutableStateOf(false)
    private var _universitiesList: List<University> by mutableStateOf(universities)
    private var _universitiesLoaded: Boolean by mutableStateOf(true)

    var openBottomSheet
        get() = _openBottomSheet
        set(value) { _openBottomSheet = value }

    var selectedUniversity
        get() = _selectedUniversity
        set(value) { _selectedUniversity = value }
    var creditHourChecked
        get() = _creditHourChecked
        set(value) { _creditHourChecked = value }
    var academicYearChecked
        get() = _academicYearChecked
        set(value) { _academicYearChecked = value }
    var passwordVisibility
        get() = _passwordVisibility
        set(value) { _passwordVisibility = value }
    var userName
        get() = _userName
        set(value) { _userName = value }
    var userPassword
        get() = _userPassword
        set(value) { _userPassword = value }
    var universitySearchBarQuery
        get() = _universitySearchBarQuery
        set(value) { _universitySearchBarQuery = value }
    var searchBarActive
        get() = _searchBarActive
        set(value) { _searchBarActive = value }
    var universitiesList
        get() = _universitiesList
        set(value) { _universitiesList = value }
    var universitiesLoaded
        get() = _universitiesLoaded
        set(value) { universitiesLoaded = value }

}