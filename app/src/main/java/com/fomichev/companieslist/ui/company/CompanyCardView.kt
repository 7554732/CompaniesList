package com.fomichev.companieslist.ui.company

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.material.Text
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.fomichev.companieslist.R
import com.fomichev.companieslist.domain.CompanyCardModel
import com.fomichev.companieslist.domain.CompanyItemModel
import com.fomichev.companieslist.network.CompaniesNetwork.API_ENDPOINT

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
        Row{
            if(company.img.length > 0) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(API_ENDPOINT + company.img)
                        .crossfade(true)
                        .build(),
                    placeholder = painterResource(R.drawable.ic_baseline_hourglass_empty_24),
                    error = painterResource(R.drawable.ic_baseline_broken_image_24),
                    contentDescription = null,
                    modifier = Modifier
                        .size(120.dp, 180.dp)
                )
            }
            Text(
                text  = company.name,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 8.dp)
            )
        }
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