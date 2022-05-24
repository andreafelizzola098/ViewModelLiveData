package com.example.viewmodellivedata.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Fragment3ViewModel : ViewModel(){

    val name = MutableLiveData<String>()

    fun changeName(){
        name.postValue("hola soy frag 3")
    }
}