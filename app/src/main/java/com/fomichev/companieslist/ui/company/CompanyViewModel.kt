package com.fomichev.companieslist.ui.company

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class CompanyViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {

    private var _id = MutableLiveData<String>(checkNotNull(savedStateHandle["id"]))
    val id: LiveData<String>
        get() = _id
}
