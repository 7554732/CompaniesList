package com.fomichev.companieslist.ui.companies

import androidx.lifecycle.LiveData
import com.fomichev.companieslist.domain.CompanyItemModel

interface CompaniesViewModelApi {

    val companies: LiveData<List<CompanyItemModel>>

}
