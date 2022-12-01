package com.fomichev.companieslist.ui.company

import androidx.compose.runtime.Composable
import androidx.compose.material.Text
import androidx.compose.runtime.livedata.observeAsState

@Composable
fun CompanyCardView(viewModel: CompanyViewModel) {
    val company = viewModel.company.observeAsState()

    company.value?.let { Text(text  = it.name) }
}
