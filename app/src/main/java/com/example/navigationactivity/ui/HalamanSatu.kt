package com.example.navigationactivity.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.navigationactivity.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanSatu(
    pilihanRasa: List<String>,
    onSelectionChanged: (String) -> Unit,
    onConfirmButtonClicked: (Int) -> Unit,
    onNextButtonClicked: () -> Unit,
    onCancelButtonClicked: () -> Unit,
    modifier: Modifier = Modifier,
) {
    var selectedFlavor by rememberSaveable {
        mutableStateOf("")
    }

    var textTotalOrder by rememberSaveable {
        mutableStateOf("")
    }

    Column(modifier = modifier, verticalArrangement = Arrangement.SpaceBetween) {
        Column(modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium))) {
            pilihanRasa.forEach { item ->
                Row(modifier = Modifier.selectable(
                    selected = selectedFlavor == item,
                    onClick = {
                        selectedFlavor = item
                        onSelectionChanged(item)
                    }
                ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(selected = selectedFlavor == item,
                        onClick = {
                            selectedFlavor = item
                            onSelectionChanged(item)
                        }
                    )
                    Text(item)
                }
            }
            Divider(
                thickness = dimensionResource(R.dimen.thickness_divider),
                modifier = Modifier.padding(bottom = dimensionResource(R.dimen.padding_medium))
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_medium))
                    .weight(1f, false),
                horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
            ) {
                OutlinedTextField(
                    value = textTotalOrder,
                    onValueChange = { textTotalOrder = it },
                    modifier = Modifier.width(150.dp),
                    label = { Text("Jumlah Order") },
                    singleLine = true,
                    shape = MaterialTheme.shapes.large,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                Button(
                    onClick = { onConfirmButtonClicked(textTotalOrder.toInt()) },
                    enabled = textTotalOrder.isNotEmpty(),
                ) {
                    Text(stringResource(R.string.btn_confirm))
                }

            }
            Divider(
                thickness = dimensionResource(R.dimen.thickness_divider),
                modifier = Modifier.padding(bottom = dimensionResource(R.dimen.padding_medium))
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_medium))
                    .weight(1f, false),
                horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
                verticalAlignment = Alignment.Bottom
            ) {
                OutlinedButton(
                    onClick = onCancelButtonClicked,
                    modifier = Modifier.weight(1f)
                ) {
                    Text(stringResource(id = R.string.btn_cancel))
                }
                Button(
                    onClick = onNextButtonClicked,
                    modifier = Modifier.weight(1f),
                    enabled = textTotalOrder.isNotEmpty(),
                ) {
                        Text(stringResource(R.string.btn_next))
                }
            }
        }
    }
}
