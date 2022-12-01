package com.fomichev.companieslist.repository

import com.fomichev.companieslist.domain.CompanyCardModel
import com.fomichev.companieslist.domain.CompanyItemModel
import kotlinx.coroutines.flow.Flow

interface CompaniesRepositoryApi {
    val companies: Flow<List<CompanyItemModel>>
    suspend fun refreshCompanies()
    suspend fun getCompany(id: String): CompanyCardModel
}
