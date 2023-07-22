package com.polendina.mustudentportal.loginpage

import android.provider.CalendarContract
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SheetState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.polendina.mustudentportal.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UniversitiesBottomSheet(
    bottomSheetState: SheetState,
    universities: List<University>,
    onQueryChange: (newQuery: String) -> Unit,
    onSearch: (String) -> Unit,
    onDismissRequest: () -> Unit,
    selectedUniversity: University,
    onSelectingUniversity: (University) -> Unit,
    modifier: Modifier = Modifier
) {
    ModalBottomSheet(
        sheetState = bottomSheetState,
        onDismissRequest = onDismissRequest
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(10.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .height(70.dp)
            ) {
                SearchBar(
                    query = stringResource(id = R.string.university_search),
                    onQueryChange = onQueryChange,
                    onSearch = onSearch,
                    active = true,
                    onActiveChange = {},
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = null
                        )
                    },
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                ) {
                }
            }
            Surface(
                modifier = Modifier
                    .height(500.dp)
            ) {
                LazyColumn() {
                    items(universities) {
                        Card(
                            colors  = CardDefaults.cardColors(
                                containerColor = if (selectedUniversity == it) MaterialTheme.colorScheme.primaryContainer else Color.LightGray
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp)
                                .padding(vertical = 10.dp)
                                .clickable { onSelectingUniversity(it) }
                        ) {
                            Text(
                                text = it.name,
                                modifier = Modifier
                                    .align(Alignment.End)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun UniversitiesBottomSheetPreview() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        UniversitiesBottomSheet(
            bottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = false),
            universities = univerisities,
            onQueryChange = {},
            onSearch = {},
            onDismissRequest = {},
            selectedUniversity = univerisities[1],
            onSelectingUniversity = {}
        )
    }
}