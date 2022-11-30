package com.fomichev.companieslist.ui.companies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.fomichev.companieslist.domain.CompanyItemModel
import com.fomichev.companieslist.repository.CompaniesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CompaniesViewModel @Inject constructor(private val repository: CompaniesRepository): ViewModel(), CompaniesViewModelApi{

    override val companies: LiveData<List<CompanyItemModel>>
        get() = repository.companies.asLiveData()

    init {
        refreshDataFromRepository()
    }


    fun refreshDataFromRepository() {
        viewModelScope.launch {
            try {
                withContext(Dispatchers.IO) {
                    repository.refreshCompanies()
                }

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}