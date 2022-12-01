package com.fomichev.companieslist.ui.companies

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fomichev.companieslist.domain.CompanyItemModel
import androidx.compose.runtime.livedata.observeAsState
@Composable
fun CompaniesListView(viewModel: CompaniesViewModelApi, onItemClick: (id: String) -> Unit){
    val companies = viewModel.companies.observeAsState()

    Box(
        modifier = Modifier.padding(all = 1.dp)
    ) {
        LazyColumn {
            companies.value?.map { item { CompanyCard(it, onClick = onItemClick) } }
        }
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CompanyCard(company: CompanyItemModel, onClick: (id: String) -> Unit) {
    Card(
        onClick = {onClick(company.id)},
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 1.dp, vertical = 1.dp),
        elevation = 2.dp
    ) {
        Column() {
            Text(text = company.name)
        }
    }
}

@Preview(showBackground = true, widthDp = 420)
@Composable
fun PreviewCompanies() {
    CompaniesListView(FakeCompaniesViewModel()){}
}