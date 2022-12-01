package com.fomichev.companieslist.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.fomichev.companieslist.ui.companies.CompaniesListView
import com.fomichev.companieslist.ui.companies.CompaniesViewModel
import com.fomichev.companieslist.ui.company.CompanyCardView
import com.fomichev.companieslist.ui.company.CompanyViewModel

@Composable
fun NavigationComponent(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "CompaniesList"
    ) {
        composable("CompaniesList") {
            val companiesViewModel = hiltViewModel<CompaniesViewModel>()
            CompaniesListView(companiesViewModel) { id ->
                navController.navigate("CompanyCard/" + id)
            }
        }
        composable("CompanyCard/{id}") {
            val companyViewModel = hiltViewModel<CompanyViewModel>()
            CompanyCardView(companyViewModel)
        }
    }
}