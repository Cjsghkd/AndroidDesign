package com.example.androiddesign


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Ch2_MainViewModel() : ViewModel() {
    // LiveData -> 값이 변경되는 경우 MutableLiveData 로 선언한다
    var count = MutableLiveData<Int>()

    init {
        count.value = 0
    }

    fun increase() {
        count.value = count.value?.plus(1)
    }

    fun decrease() {
        count.value = count.value?.minus(1)
    }
}