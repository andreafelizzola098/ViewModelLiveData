package com.example.viewmodellivedata.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Fragment1ViewModel : ViewModel(){

    val name = MutableLiveData<String>("Valor por defecto")

    fun changeName(){
        name.postValue("Fragmento 1")
    }
}