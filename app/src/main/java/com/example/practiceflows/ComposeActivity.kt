package com.example.practiceflows

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class ComposeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeUI()
        }
    }
}

@Composable
fun ComposeUI() {
    val postViewModel : PostViewModel = viewModel()
    val posts by postViewModel.result.collectAsState()

    MaterialTheme {
        Surface(color = MaterialTheme.colors.background) {
            posts?.let {
                LazyColumn {
                    items(it.size) { index ->
                        val post = it[index]
                        PostItem(post)
                    }
                }
            }
        }
    }
}

@Composable
fun PostItem(post: Post) {
    Column(
        modifier = Modifier.padding(12.dp)
    ) {
        Text(text = "UserId: ${post.userId}")
        Text(text = "Id: ${post.id}")
        Text(text = "Title: ${post.title}")
        Text(text = "Body: ${post.body}")
    }
}
