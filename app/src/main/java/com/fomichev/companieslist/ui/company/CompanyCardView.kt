package com.fomichev.companieslist.ui.company

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.material.Text
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.fomichev.companieslist.domain.CompanyCardModel
import com.fomichev.companieslist.domain.CompanyItemModel

@Composable
fun CompanyCardView(viewModel: CompanyViewModel) {
    val company = viewModel.company.observeAsState()

    company.value?.let {
        CompanyCard(it)
    }
}

@Composable
fun CompanyCard(company: CompanyCardModel, onClick: (id: String) -> Unit = {}) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier.
        verticalScroll(scrollState)
            .padding(all = 4.dp)
    ){
        Text(
            text  = company.name,
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(all = 8.dp)
        )
        Text(
            text  = company.description,
            modifier = Modifier.padding(all = 8.dp)
        )
        Row() {
            Text(
                text  = company.lat,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(all = 8.dp)
            )
            Text(
                text  = company.lon,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(all = 8.dp)
            )
        }
        Text(
            text  = company.www,
            color = Color.Blue,
            modifier = Modifier.padding(all = 8.dp)
        )
        Text(
            text  = company.phone,
            modifier = Modifier.padding(all = 8.dp)
        )
    }
}