package com.fomichev.companieslist.ui.company

import androidx.lifecycle.LiveData
import com.fomichev.companieslist.domain.CompanyCardModel

interface CompanyViewModelApi {

    val company: LiveData<CompanyCardModel>
}
