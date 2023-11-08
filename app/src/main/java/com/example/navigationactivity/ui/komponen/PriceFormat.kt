package com.example.navigationactivity.ui.komponen

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3. Text
import androidx.compose.ui.res.stringResource
import com.example.navigationactivity.R

@Composable
fun PriceTagFormat(subTotal: String, modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.subtotal_price, subTotal),
        modifier = modifier,
        style = MaterialTheme.typography.headlineSmall
    )
}