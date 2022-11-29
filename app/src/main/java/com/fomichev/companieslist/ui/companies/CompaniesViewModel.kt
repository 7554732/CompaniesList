package com.fomichev.companieslist.ui.companies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fomichev.companieslist.domain.CompanyItemModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CompaniesViewModel @Inject constructor(): ViewModel(), CompaniesViewModelApi{

    private var _companies = MutableLiveData(listOf<CompanyItemModel>())
    override val companies: LiveData<List<CompanyItemModel>>
        get() = _companies

}