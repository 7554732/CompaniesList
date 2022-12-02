package com.fomichev.companieslist.ui.company

import android.util.Log
import androidx.lifecycle.*
import com.fomichev.companieslist.domain.CompanyCardModel
import com.fomichev.companieslist.domain.CompanyItemModel
import com.fomichev.companieslist.repository.CompaniesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CompanyViewModel @Inject constructor(
    private val repository: CompaniesRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel(), CompanyViewModelApi {

    private var id: String = checkNotNull(savedStateHandle["id"])

    private var _company = MutableLiveData(CompanyCardModel())
    override val company: LiveData<CompanyCardModel>
        get() = _company

    init {
        getCompany(id)
    }

    fun getCompany(id: String) {
        viewModelScope.launch {
            _company.value = try {
                withContext(Dispatchers.IO) {
                    repository.getCompany(id)
                }
            } catch (e: Exception) {
                e.printStackTrace()
                CompanyCardModel()
            }
        }
    }

}
