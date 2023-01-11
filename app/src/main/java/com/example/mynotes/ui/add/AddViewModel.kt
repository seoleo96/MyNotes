package com.example.mynotes.ui.add

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddViewModel : ViewModel() {

    var notesLiveData = MutableLiveData<List<String>>(emptyList())
        private set

    init {

    }
}