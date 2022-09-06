package com.akash.newsappmm.ui.presentation.Components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.akash.newsappmm.domain.model.Result

@Composable
fun StaggeredGridView(
    results : List<Result>,
    onClick : (Result) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(5.dp)
        ) {
            CustomStaggeredVerticalGrid(
                numColumns = 2,
                modifier = Modifier.padding(5.dp)
            ) {
                results.forEach { result ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp)
                            .clickable {
                                onClick(result)
                            },
                        elevation = 10.dp,
                        shape = RoundedCornerShape(10.dp)
                    ) {
                       Column(
                           modifier = Modifier
                               .fillMaxSize()
                               .align(Alignment.CenterHorizontally),
                          horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                           Text(
                               modifier = Modifier
                                   .padding(4.dp),
                               text = result.title,
                               style = TextStyle(
                                   fontSize = 16.sp,
                                   color = Color.Black
                               )
                           )
                           Spacer(modifier =Modifier.height(8.dp))
                           Text(
                               modifier = Modifier
                                   .padding(4.dp),
                               text = result.description,
                               style = TextStyle(
                                   fontSize = 14.sp,
                                   color = Color.Gray
                               ),
                               maxLines = 8,
                               overflow = TextOverflow.Ellipsis
                           )


                        }
                    }
                }
            }
        }
    }
}
@Composable
fun CustomStaggeredVerticalGrid(
    modifier: Modifier = Modifier,
    numColumns: Int = 2,
    content: @Composable () -> Unit
) {

    Layout(
        content = content,
        modifier = modifier
    ) { measurable, constraints ->
        val columnWidth = (constraints.maxWidth / numColumns)
        val itemConstraints = constraints.copy(maxWidth = columnWidth)
        val columnHeights = IntArray(numColumns) { 0 }
        val placeables = measurable.map { measurable2 ->

            val column = testColumn(columnHeights)
            val placeable = measurable2.measure(itemConstraints)
            columnHeights[column] += placeable.height
            placeable
        }

        val height =
            columnHeights.maxOrNull()?.coerceIn(constraints.minHeight, constraints.maxHeight)
                ?: constraints.minHeight
        layout(
            width = constraints.maxWidth,
            height = height
        ) {
            val columnYPointers = IntArray(numColumns) { 0 }

            placeables.forEach { placeable ->
                val column = testColumn(columnYPointers)

                placeable.place(
                    x = columnWidth * column,
                    y = columnYPointers[column]
                )
                columnYPointers[column] += placeable.height
            }
        }
    }
}

private fun testColumn(columnHeights: IntArray): Int {
    var minHeight = Int.MAX_VALUE
    var columnIndex = 0

    columnHeights.forEachIndexed { index, height ->
        if (height < minHeight) {
            minHeight = height
            columnIndex = index
        }
    }
    return columnIndex
}