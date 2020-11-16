package com.example.tictactoe

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameHomeViewModel : ViewModel() {

    val data=MutableLiveData<List<Game>>()
    val _data:LiveData<List<Game>>
        get() =data

    init {
        setData()

    }

    private fun setData(){
        val list=ArrayList<Game>()
        list.add(Game(1))
        list.add(Game(2))
        list.add(Game(3))
        list.add(Game(4))
        list.add(Game(5))
        list.add(Game(6))
        list.add(Game(7))
        list.add(Game(8))
        list.add(Game(9))
        data.value=list
    }
}