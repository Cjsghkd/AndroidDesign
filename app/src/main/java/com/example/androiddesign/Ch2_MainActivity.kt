package com.example.androiddesign

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.androiddesign.databinding.ActivityCh2MainBinding

class Ch2_MainActivity : AppCompatActivity() {

    private lateinit var mBinding : ActivityCh2MainBinding
    private val model : Ch2_MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_ch2_main)

        mBinding.lifecycleOwner = this
        mBinding.viewModel = model
    }
}
