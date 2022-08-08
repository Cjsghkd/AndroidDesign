package com.example.androiddesign

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androiddesign.databinding.ActivityCh1MainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Ch1_MainActivity : AppCompatActivity() {

    private val viewModel : Ch1_MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityCh1MainBinding>(this, R.layout.activity_ch1_main)
        binding.viewModel = viewModel

        val mAdapter = Ch1_RecyclerViewAdapter(this, viewModel)
        binding.recyclerview.apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(applicationContext)
        }

        viewModel.allUsers.observe(this, Observer { users ->
            users?.let { mAdapter.setUsers(it) }
        })

        binding.button.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO) {
                viewModel.insert(
                    Ch1_Entity(
                        0, binding.edit.text.toString()
                    )
                )
            }
        }
    }
}