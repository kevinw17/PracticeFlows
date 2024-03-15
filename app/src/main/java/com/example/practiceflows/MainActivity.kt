package com.example.practiceflows

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.practiceflows.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var postViewModel : PostViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        postViewModel = ViewModelProvider(this).get(PostViewModel::class.java)

        lifecycleScope.launch {
            postViewModel.result.collect { posts ->
                if (posts != null) {
                    for (post in posts) {
                        binding.textView.append("UserId: ${post.userId}\n")
                        binding.textView.append("Id: ${post.id}\n")
                        binding.textView.append("Title: ${post.title}\n")
                        binding.textView.append("Body: ${post.body}\n\n")
                    }
                }
            }
        }
    }

}